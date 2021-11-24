package com.hybrid.api;

import com.hybrid.request.LoginRequest;
import com.hybrid.request.SignupRequest;
import com.hybrid.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserAPI {

//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//
//    @PostMapping("/user/login")
//    public  ResponseEntity<?> loginAccount(@Validated @RequestBody LoginRequest loginRequest){
//        return userDetailsService.authenticateUser(loginRequest);
//    }
//
//    @PostMapping("/user/logout")
//    public ResponseEntity<?> logoutAccount(@Validated @RequestBody LoginRequest loginRequest ){
//        return userDetailsService.logoutUsser(loginRequest);
//    }
//
//    @PostMapping("/admin/createUser")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> signupAccount(@Validated @RequestBody SignupRequest signupRequest ){
//        return userDetailsService.registerUser(signupRequest);
//    }
}
