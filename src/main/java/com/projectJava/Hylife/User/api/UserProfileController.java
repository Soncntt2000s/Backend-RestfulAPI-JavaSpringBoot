package com.projectJava.Hylife.User.api;

import com.projectJava.Hylife.User.request.LoginRequest;
import com.projectJava.Hylife.User.request.UserProfileRequest;
import com.projectJava.Hylife.User.service.UserDetailsServiceImpl;
import com.projectJava.Hylife.User.service.UserProfileService;
import com.projectJava.Hylife.User.service.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserProfileController {

    @Autowired
    UserProfileServiceImpl userProfileService;

    @PostMapping("/user/update_profile")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> updateProfileUser(@Validated @RequestBody UserProfileRequest userProfileRequest ){
        return userProfileService.updateProfileUser(userProfileRequest);
    }
}
