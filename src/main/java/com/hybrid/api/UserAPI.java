package com.hybrid.api;

import com.hybrid.request.UserRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.service.IUserService;
import com.hybrid.service.impl.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping("/api/admin")
public class UserAPI {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    /*
   Create user by check role user or admin to add Database
    */
    @PostMapping("/create-user")
    public BaseResponse createUser(@RequestBody UserRequest userRequest){
        if(userService.checkExistEmail(userRequest.getEmail())){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setReponseCode(400);
            baseResponse.setMessage("Email is already exist");
            return baseResponse;
        }
        userService.createUser(userRequest);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setReponseCode(200);
        baseResponse.setMessage("SUCCESFULLY");
        return baseResponse;
    }
}
