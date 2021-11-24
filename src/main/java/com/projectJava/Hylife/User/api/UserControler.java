package com.projectJava.Hylife.User.api;

import com.projectJava.Hylife.User.request.*;
import com.projectJava.Hylife.User.entity.Roles;
import com.projectJava.Hylife.User.entity.Users;
import com.projectJava.Hylife.User.repository.RoleRepository;
import com.projectJava.Hylife.User.repository.UserRepository;
import com.projectJava.Hylife.User.response.JwtResponse;
import com.projectJava.Hylife.User.response.MessageResponse;
import com.projectJava.Hylife.User.service.UserDetailsImpl;
import com.projectJava.Hylife.User.service.UserDetailsServiceImpl;
import com.projectJava.Hylife.User.common.ERole;
import com.projectJava.Hylife.User.common.TokenJwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/user/login")
    public  ResponseEntity<?> loginAccount(@Validated @RequestBody LoginRequest loginRequest){
        return userDetailsService.authenticateUser(loginRequest);
    }

    @PostMapping("/user/logout")
    public ResponseEntity<?> logoutAccount(@Validated @RequestBody LoginRequest loginRequest ){
        return userDetailsService.logoutUsser(loginRequest);
    }
    
    @PostMapping("/admin/createUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> signupAccount(@Validated @RequestBody SignupRequest signupRequest ){
        return userDetailsService.registerUser(signupRequest);
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

}
