package com.projectJava.Hylife.User.service;

import com.projectJava.Hylife.User.common.TokenJwtUtils;
import com.projectJava.Hylife.User.config.AuthTokenFilter;
import com.projectJava.Hylife.User.entity.Roles;
import com.projectJava.Hylife.User.entity.UserProfile;
import com.projectJava.Hylife.User.repository.RoleRepository;
import com.projectJava.Hylife.User.repository.UserprofileRepository;
import com.projectJava.Hylife.User.request.LoginRequest;
import com.projectJava.Hylife.User.request.UserProfileRequest;
import com.projectJava.Hylife.User.response.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class UserProfileServiceImpl implements UserProfileService{

    private static final Logger logger = LoggerFactory.getLogger(TokenJwtUtils.class);

    @Autowired
    UserprofileRepository userprofileRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TokenJwtUtils jwtUtils;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    AuthTokenFilter authTokenFilter;


    @Transactional
    public ResponseEntity<?> updateProfileUser(@Validated @RequestBody UserProfileRequest userProfileRequest ) {
//            String email = jwtUtils.getEmailFromJwtToken(userProfileRequest.getAccessToken());
//            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//            System.out.println(userDetails);
        try {
//            String jwt = authTokenFilter.parseJwt(userProfileRequest.getAccessToken());
            if(userProfileRequest.getAccessToken() != null && jwtUtils.validateJwtToken(userProfileRequest.getAccessToken())){
                String email = jwtUtils.getEmailFromJwtToken(userProfileRequest.getAccessToken());
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                UserProfile userProfile = new UserProfile();
                //Kiểm tra dữ kiệu publicStatic nhập vào
                if(userProfileRequest.getPublicStatic()){
                    userProfile.setFacebook(userProfileRequest.getFacebook());
                    userProfile.setNumberPhone(userProfile.getNumberPhone());
                    userProfile.setBirthday(userProfileRequest.getBirthday());
                    int publicStatic = 1;
                }else{
                    int publicStatic = 0;
                }
                //Kiểm tra dữ kiệu gender nhập vào
                if(userProfileRequest.getGender()){
                    int gender = 1;
                }else{
                    int gender = 0;
                }
                if(jwtUtils.validateJwtToken(userProfileRequest.getAccessToken())){
                    userProfile.setFullName(userProfileRequest.getFullName());
                    userProfile.setBirthday(userProfileRequest.getBirthday());
                    userProfile.setDescription(userProfileRequest.getDescription());
                }
            }
        }catch (Exception e){
            logger.error("Cannot set user authentication: {}",e.getMessage());
        }
        return ResponseEntity.ok(new MessageResponse("Update User Profile Successfully!", 200));
    }

    @Transactional
    public ResponseEntity<?> getProfileUser(UserProfileRequest userProfileRequest) {
        return null;
    }
}
