package com.hybrid.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hybrid.entity.ForgotPasswordEntity;
import com.hybrid.entity.UserEntity;
import com.hybrid.repository.ForgotPasswordRepository;
import com.hybrid.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepo;
     
	@Autowired
	private ForgotPasswordRepository forgotRepo;
	
    public int updateResetPasswordToken(String token, String email){
        UserEntity userEntity = userRepo.findOneByEmail(email);
        ForgotPasswordEntity forgotPass = new ForgotPasswordEntity();
        if (userEntity != null) {
        	forgotPass.setEmail(email);
        	forgotPass.setToken(token);
        	System.out.println(forgotPass.getCreatedAt());
        	forgotRepo.save(forgotPass);
//            customer.setResetPasswordToken(token);
//            customerRepo.save(customer);
        	return 1;
        } else {
            return 0;
        }
    }
     
    public ForgotPasswordEntity getByResetPasswordToken(String token) {
        return forgotRepo.findOneByToken(token);
    }
    
    public UserEntity getUser(String email)
    {
    	UserEntity userEntity = userRepo.findOneByEmail(email);
    	return userEntity;
    }
     
    public void updatePassword(UserEntity userEntity, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        userEntity.setPassword(encodedPassword);
         
        //customer.setResetPasswordToken(null);
        userRepo.save(userEntity);
    }
}
