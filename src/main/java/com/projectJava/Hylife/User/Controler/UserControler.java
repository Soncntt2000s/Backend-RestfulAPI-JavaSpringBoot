package com.projectJava.Hylife.User.Controler;

import com.projectJava.Hylife.User.DTO.*;
import com.projectJava.Hylife.User.Entity.Roles;
import com.projectJava.Hylife.User.Entity.Users;
import com.projectJava.Hylife.User.Repository.RoleRepository;
import com.projectJava.Hylife.User.Repository.UserRepository;
import com.projectJava.Hylife.User.Service.UserDetailsImpl;
import com.projectJava.Hylife.User.Service.UserDetailsServiceImpl;
import com.projectJava.Hylife.User.common.ERole;
import com.projectJava.Hylife.User.common.JwtUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
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

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/user/login")
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
                    jwt,
                    200L,
                    "Login successfully",
                    userDetails.getId(),
                    userDetails.getEmail(),
                    roles
            ));
        }
    }
    
    @PostMapping("/user/createUser")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signupRequest){
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(" Email is already taken!"));
        }
        if(signupRequest.getStatus()){
            int status = 1;
        }else{
            int status = 0;
        }
        Timestamp createdAt = signupRequest.getCreatedAt();

        Set<String> strRole = signupRequest.getRole();


        Set<Roles> roles = new HashSet<>();

        if(strRole == null){
            Roles userRole = roleRepository.findByName(ERole.User)
                    .orElseThrow(() -> new RuntimeException(" Role is not found."));
            roles.add(userRole);
        }else{
            strRole.forEach(role-> {
                switch (role){
                    case "Admin":
                        Roles adminRoles = roleRepository.findByName(ERole.Admin)
                                .orElseThrow(() -> new RuntimeException(" Role is not found."));
                        roles.add(adminRoles);
                        break;
                    case "User":
                        Roles userRole = roleRepository.findByName(ERole.User)
                                .orElseThrow(() -> new RuntimeException(" Role is not found."));
                        roles.add(userRole);
                        break;
                    default:
                        ResponseEntity.ok(new MessageResponse("Role is not found!"));
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
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable(name = "id") Integer id){
//        Set<Roles> roles = new HashSet<>();
//        userRepository.deleteById(id);
//        return "Success";
//    }

    @GetMapping("/admin/test")
    public  String admin(){
        return "error";
    }
}
