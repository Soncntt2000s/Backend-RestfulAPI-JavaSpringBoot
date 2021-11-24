package com.projectJava.Hylife.User.service;

import com.projectJava.Hylife.User.entity.UserProfile;
import com.projectJava.Hylife.User.entity.Users;
import com.projectJava.Hylife.User.request.UserProfileRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface UserProfileService {

    UserProfile updateProfileUserById(@Validated @RequestBody UserProfileRequest userProfileRequest );

    public ResponseEntity<?> getProfileUser(@Validated @RequestBody UserProfileRequest userProfileRequest );

    UserProfile insertUserProfile(UserProfileRequest userProfileRequest);




}
