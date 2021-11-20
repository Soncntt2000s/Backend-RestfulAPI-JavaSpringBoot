package com.projectJava.Hylife.User.service;

import com.projectJava.Hylife.User.common.ERole;
import com.projectJava.Hylife.User.common.TokenJwtUtils;
import com.projectJava.Hylife.User.entity.Roles;
import com.projectJava.Hylife.User.entity.Users;
import com.projectJava.Hylife.User.repository.RoleRepository;
import com.projectJava.Hylife.User.repository.UserRepository;
import com.projectJava.Hylife.User.request.LoginRequest;
import com.projectJava.Hylife.User.request.SignupRequest;
import com.projectJava.Hylife.User.response.JwtResponse;
import com.projectJava.Hylife.User.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TokenJwtUtils jwtUtils;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = this.userRepository .findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("Email not found with email : "+email));
        return UserDetailsImpl.build(users);
    }

    @Transactional
    public  ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest){
        if(!userRepository.existsByEmail(loginRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(" Email is not already taken on DB!",401));
        }else {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail()
                            , loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            System.out.println(jwtUtils.getEmailFromJwtToken(jwt));
            return ResponseEntity.ok(new JwtResponse(
                    jwt,
                    200L,
                    "Login successfully",
                    userDetails.getId(),
                    roles
            ));
        }
    }

    @Transactional
    public ResponseEntity<?> logoutUsser(@Validated @RequestBody LoginRequest loginRequest ){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail()
                        , loginRequest.getPassword())
        );
        String jwt = jwtUtils.generateJwtToken(authentication);
        if(jwtUtils.getEmailFromJwtToken(jwt).equals(authentication.getName())){
            ResponseEntity.ok(new MessageResponse(authentication.getName(),200));
        }
        return ResponseEntity.ok(new MessageResponse(authentication.getName(),400));
    }

    @Transactional
    public  ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(" Email is already taken!", 401));
        }
        if (signupRequest.getStatus()) {
            int status = 1;
        } else {
            int status = 0;
        }
        Timestamp createdAt = signupRequest.getCreatedAt();

        Set<String> strRole = signupRequest.getRole();


        Set<Roles> roles = new HashSet<>();

        if (strRole == null) {
            Roles userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException(" Role is not found."));
            roles.add(userRole);
        } else {
            strRole.forEach(role -> {
                switch (role) {
                    case "ADMIN":
                        Roles adminRoles = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException(" Role is not found."));
                        roles.add(adminRoles);
                        break;
                    case "USER":
                        Roles userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException(" Role is not found."));
                        roles.add(userRole);
                        break;
                    default:
                        ResponseEntity.ok(new MessageResponse("Role is not found!", 400));
                        break;
                }
            });
        }
        Users users = new Users(
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()),
                roles,
                signupRequest.getStatus(),
                createdAt
        );
        users.setRoles(roles);
        userRepository.save(users);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!", 200));
    }

}
