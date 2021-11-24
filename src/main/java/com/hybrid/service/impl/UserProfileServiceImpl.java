package com.hybrid.service.impl;

import com.hybrid.common.JwtUtils;
import com.hybrid.config.AuthTokenFilter;
import com.hybrid.entity.*;
import com.hybrid.repository.*;
import com.hybrid.request.UserProfileRequest;
import com.hybrid.service.impl.UserDetail;
import com.hybrid.service.impl.UserDetailsServiceImpl;
import com.hybrid.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import sun.plugin.util.UserProfile;

import java.util.List;


@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserProfileRepository userprofileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    AuthTokenFilter authTokenFilter;


    @Transactional
    public UserProfileEntity updateProfileUserById(@Validated @RequestBody UserProfileRequest userProfileRequest) {

            //Kiểm tra departments
            DepartmentEntity departmentEntity = departmentRepository.findByName(userProfileRequest.getDepartments());
//            System.out.println(departments);
//            Set<Departments> departments1 = new HashSet<>();
//            departments1.add(departments);
            //Kiểm tra positions
            PositionEntity positionEntity = positionRepository.findByName(userProfileRequest.getPositions());
//            Set<Positions> positions1 = new HashSet<>();
//            positions1.add(positions);
            //Kiểm tra branchs
            BranchEntity branchEntity = branchRepository.findByName(userProfileRequest.getBranches());
//            Set<Branchs> branchs1 = new HashSet<>();
//            branchs1.add(branchs);
            //Lấy ra id User từ token

            UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserEntity users = userRepository.findOneById(userDetail.getId());
            //add các object vô userprofile
            UserProfileEntity userProfile = new UserProfileEntity(
                userProfileRequest.getPublicStatic(),
                userProfileRequest.getNumberPhone(),
                userProfileRequest.getBirthday(),
                userProfileRequest.getGender(),
                userProfileRequest.getFacebook(),
                userProfileRequest.getFullName(),
                userProfileRequest.getDescription(),
                userProfileRequest.getNameImage(),
                positionEntity,
                branchEntity,
                departmentEntity
            );
            userProfile.setDepartment(departmentEntity);
            userProfile.setPosition(positionEntity);
            userProfile.setUser(users);
            userProfile.setBranch(branchEntity);
            return userprofileRepository.save(userProfile);
    }


    @Transactional
    public ResponseEntity<?> getProfileUser(UserProfileRequest userProfileRequest) {
        return null;
    }

    @Override
    @Transactional
    public UserProfileEntity insertUserProfile(UserProfileRequest userProfileRequest) {

        UserProfileEntity userProfile = new UserProfileEntity();
        userProfileRequest.getPublicStatic();
        userProfileRequest.getFullName();
        userProfileRequest.getGender();
        userProfileRequest.getNumberPhone();
        userProfileRequest.getFacebook();
        userProfileRequest.getDescription();
        userProfileRequest.getBirthday();
        return userprofileRepository.save(userProfile);
    }

}
