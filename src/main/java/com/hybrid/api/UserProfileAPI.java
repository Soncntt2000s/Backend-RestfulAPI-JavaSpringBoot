package com.hybrid.api;

import com.hybrid.request.UserProfileRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.service.impl.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserProfileAPI {

    @Autowired
    UserProfileServiceImpl userProfileServiceImpl;

    @PostMapping("/update_profile")
    public ResponseEntity<?> updateProfile(@Validated @RequestBody UserProfileRequest userProfileRequest){
        userProfileServiceImpl.updateProfileUserById(userProfileRequest);
        return ResponseEntity.ok(new BaseResponse(200,"Update Profile Successfully !"));
    }

    @PostMapping("/")
    public ResponseEntity<?> createUserProfile(@RequestBody UserProfileRequest userProfileRequest){
        userProfileServiceImpl.insertUserProfile(userProfileRequest);
        return ResponseEntity.ok(new BaseResponse(200 , "SUCCESSFULLY"));
    }
}
