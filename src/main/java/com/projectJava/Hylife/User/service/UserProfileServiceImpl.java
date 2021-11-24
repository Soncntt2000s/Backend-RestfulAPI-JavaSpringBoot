package com.projectJava.Hylife.User.service;

import com.projectJava.Hylife.User.common.TokenJwtUtils;
import com.projectJava.Hylife.User.config.AuthTokenFilter;
import com.projectJava.Hylife.User.entity.*;
import com.projectJava.Hylife.User.repository.*;
import com.projectJava.Hylife.User.request.UserProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserprofileRepository userprofileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ImageFileDBRepository imageFileDBRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TokenJwtUtils jwtUtils;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    AuthTokenFilter authTokenFilter;


    @Transactional
    public UserProfile updateProfileUserById(@Validated @RequestBody UserProfileRequest userProfileRequest) {

        //Kiểm tra dữ liệu publicStatic nhập vào
            if(userProfileRequest.getPublicStatic()){
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
            //Kiểm tra departments
            Departments departments = departmentRepository.findByName(userProfileRequest.getDepartments());
//            System.out.println(departments);
//            Set<Departments> departments1 = new HashSet<>();
//            departments1.add(departments);
            //Kiểm tra positions
            Positions positions = positionRepository.findByName(userProfileRequest.getPositions());
//            Set<Positions> positions1 = new HashSet<>();
//            positions1.add(positions);
            //Kiểm tra branchs
            Branchs branchs = branchRepository.findByName(userProfileRequest.getBranches());
//            Set<Branchs> branchs1 = new HashSet<>();
//            branchs1.add(branchs);
            FileImageDB fileImageDB = imageFileDBRepository.getById(userProfileRequest.getNameImage());
            //Lấy ra id User từ token

            UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println("Dây là Huy " + userDetailsImpl.getId());
            Users users = userRepository.findUserById(userDetailsImpl.getId());
            UserProfile userProfile1 = new UserProfile(users);
            System.out.println(userprofileRepository.getById(userProfile1.getId()));
            System.out.println("Đây là User " + users);
            //add các object vô userprofile
            UserProfile userProfile = new UserProfile(
                positions,
                userProfileRequest.getPublicStatic(),
                userProfileRequest.getFullName(),
                userProfileRequest.getGender(),
                branchs,
                departments,
                userProfileRequest.getNumberPhone(),
                userProfileRequest.getFacebook(),
                userProfileRequest.getDescription(),
                userProfileRequest.getBirthday(),
                fileImageDB
            );
            userProfile.setDepartment(departments);
            userProfile.setPositions(positions);
            userProfile.setUsers(users);
            userProfile.setBranch(branchs);
            System.out.println(userProfile);
            return userprofileRepository.save(userProfile);
    }


    @Transactional
    public ResponseEntity<?> getProfileUser(UserProfileRequest userProfileRequest) {
        return null;
    }

    @Override
    @Transactional
    public UserProfile insertUserProfile(UserProfileRequest userProfileRequest) {

        UserProfile userProfile = new UserProfile();
        userProfileRequest.getPublicStatic();
        userProfileRequest.getFullName();
        userProfileRequest.getGender();
        userProfileRequest.getNumberPhone();
        userProfileRequest.getFacebook();
        userProfileRequest.getDescription();
        userProfileRequest.getBirthday();
//        userProfile.getFullName();
//        userProfile.getBirthday();
//        userProfile.getPublicStatus();
//        userProfile.getGender();
//        userProfile.getBranch();
//        userProfile.getDepartment();
//        userProfile.getPositions();
//        userProfile.getNumberPhone();
//        userProfile.getFacebook();
//        userProfile.getDescription();
//        userProfile.getCreatedAt();
        return userprofileRepository.save(userProfile);
    }

}
