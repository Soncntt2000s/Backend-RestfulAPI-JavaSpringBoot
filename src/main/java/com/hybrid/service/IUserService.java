package com.hybrid.service;

import com.hybrid.entity.UserEntity;
import com.hybrid.repository.UserRepository;
import com.hybrid.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;

public interface IUserService {

    Boolean checkExistEmail(String email);

    UserEntity createUser(UserRequest userRequest);
}
