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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAPI {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserService iUserService;

    /*
   Create user by check role user or admin to add Database
    */
    @PostMapping("/api/admin/create-user")
    public BaseResponse createUser(@RequestBody UserRequest userRequest){
        BaseResponse baseResponse = new BaseResponse();
        if(iUserService.checkExistEmail(userRequest.getEmail())){

            baseResponse.setReponseCode(400);
            baseResponse.setMessage("Email is already exist");
        }
        else {
            iUserService.createUser(userRequest);
            baseResponse.setReponseCode(200);
            baseResponse.setMessage( "SUCCESFULLY");
        }
        return baseResponse;
    }
}
