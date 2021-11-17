package com.projectJava.Hylife.User.Controler;

import com.projectJava.Hylife.User.DTO.*;
import com.projectJava.Hylife.User.Entity.Roles;
import com.projectJava.Hylife.User.Entity.Users;
import com.projectJava.Hylife.User.Repository.RoleRepository;
import com.projectJava.Hylife.User.Repository.UserRepository;
import com.projectJava.Hylife.User.Service.UserDetailsImpl;
import com.projectJava.Hylife.User.common.ERole;
import com.projectJava.Hylife.User.common.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserControler  {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest){
        if(!userRepository.existsByEmail(loginRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(" Email is not already taken on DB!"));
        }else {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail()
                            , loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            Users users = new Users(loginRequest.getEmail(),
                    passwordEncoder.encode(loginRequest.getPassword()));
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            users.setLogin_token(jwt);
            return ResponseEntity.ok(new JwtResponse(
                    200L,
                    jwt,
                    "Login successfully",
                    userDetails.getId(),
                    userDetails.getEmail(),
                    roles
            ));
        }
    }
    
    @PostMapping("/createUser")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signupRequest){
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(" Email is already taken!"));
        }
        Users users = new Users(signupRequest.getEmail(),
               passwordEncoder.encode(signupRequest.getPassword()));
        Set<String> strRole = signupRequest.getRole();
        Set<Roles> roles = new HashSet<>();
        
        if(strRole == null){
            Roles userRole = roleRepository.findByName(ERole.User)
                    .orElseThrow(() -> new RuntimeException(" Role is not found."));
            roles.add(userRole);
        }else{
            strRole.forEach(role-> {
                switch (role){
                    case "Admin" :
                        Roles adminRoles = roleRepository.findByName(ERole.Admin)
                                .orElseThrow(() -> new RuntimeException(" Role is not found."));
                        roles.add(adminRoles);
                        break;
                    default:
                        Roles userRole = roleRepository.findByName(ERole.User)
                                .orElseThrow(() -> new RuntimeException(" Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        users.setRoles(roles);
        userRepository.save(users);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
