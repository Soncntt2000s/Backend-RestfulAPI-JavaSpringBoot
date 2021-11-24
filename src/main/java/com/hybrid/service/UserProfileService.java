package com.hybrid.service;

import com.hybrid.entity.UserProfileEntity;
import com.hybrid.request.UserProfileRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserProfileService {

    UserProfileEntity updateProfileUserById(@Validated @RequestBody UserProfileRequest userProfileRequest );

    public ResponseEntity<?> getProfileUser(@Validated @RequestBody UserProfileRequest userProfileRequest );

    UserProfileEntity insertUserProfile(UserProfileRequest userProfileRequest);




}
