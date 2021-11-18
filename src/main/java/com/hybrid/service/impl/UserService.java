package com.hybrid.service.impl;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hybrid.entity.BaseEntity;
import com.hybrid.entity.ForgotPasswordEntity;
import com.hybrid.entity.UserEntity;
import com.hybrid.repository.ForgotPasswordRepository;
import com.hybrid.repository.UserRepository;
import com.hybrid.request.PasswordRequest;
import com.hybrid.response.BaseResponse;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepo;
     
	@Autowired
	private ForgotPasswordRepository forgotRepo;
	
	@Autowired
    private JavaMailSender mailSender;
	
    public BaseResponse forgotPassword(String token, String email){
    	BaseResponse baseResponse = new BaseResponse();
        UserEntity userEntity = userRepo.findOneByEmail(email);
        ForgotPasswordEntity forgotPass = new ForgotPasswordEntity();
        if (userEntity != null) {
        	forgotPass.setEmail(email);
        	forgotPass.setToken(token);
        	System.out.println(forgotPass.getCreatedAt());
        	forgotRepo.save(forgotPass);
        	String resetPasswordLink = "/reset_password?token=" + token;
            try {
    			sendEmail(email, resetPasswordLink);
    		} catch (UnsupportedEncodingException | MessagingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            baseResponse.setReponseCode(200);
            baseResponse.setMessage("Confirmation successfully, please check mail");
        } else {
        	baseResponse.setReponseCode(401);
        	baseResponse.setMessage("Email is empty. Please input the email");
        }
        return baseResponse;
    }
    
    
//    if(userService.updateResetPasswordToken(token, email)==true)
//    {
//        String resetPasswordLink = "/reset_password?token=" + token;
//        try {
//			sendEmail(email, resetPasswordLink);
//		} catch (UnsupportedEncodingException | MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        baseDTO.setreponse_code(200);
//		baseDTO.setMessage("Confirmation successfully, please check mail");
//    }
//    else
//    {
//    	baseDTO.setreponse_code(401);
//		baseDTO.setMessage("Email is empty. Please input the email");
//    }
//    return baseDTO;
    
     
    public ForgotPasswordEntity getResetPasswordToken(String token) {
    
    	return forgotRepo.findOneByToken(token);//do token lưu riêng trong bảng forgotPassword 
        
    }
    
    public UserEntity getUser(String email)
    {
    	UserEntity userEntity = userRepo.findOneByEmail(email);
    	return userEntity;
    }
     
    public BaseResponse updatePassword(PasswordRequest passRequest) {
    	BaseResponse baseResponse = new BaseResponse();
    	String password = passRequest.getPassword();
    	String token = passRequest.getToken();
    	String confirmPassword = passRequest.getConfirmPassword();
    	if(password .equals(confirmPassword)) //đã valid password anh cofirm not null
	    {
	    	ForgotPasswordEntity forgotPasswordEntity = getResetPasswordToken(token);
	    	if (forgotPasswordEntity == null) {
	    		baseResponse.setReponseCode(401);
	    		baseResponse.setMessage("Not find email");
		    } else {
		    	UserEntity userEntity = getUser(forgotPasswordEntity.getEmail());
		    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		        String encodedPassword = passwordEncoder.encode(password);
		        userEntity.setPassword(encodedPassword);
		        //customer.setResetPasswordToken(null);
		        forgotRepo.deleteById(forgotPasswordEntity.getId());
		        userRepo.save(userEntity);
		        baseResponse.setReponseCode(200);
		        baseResponse.setMessage("Reset password successfully!");
		    }
	    }
	    else
	    {
	    	baseResponse.setReponseCode(400);
	    	baseResponse.setMessage("Confirm new password doesn't not match new password!");
	    }
    	return baseResponse;
      
    }
    
    public void sendEmail(String recipientEmail, String link)
	        throws MessagingException, UnsupportedEncodingException {
	    MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("contact@shopme.com", "Shopme Support");
	    helper.setTo(recipientEmail);
	     
	    String subject = "Here's the link to reset your password";
	     
	    String content = "<p>Hello,</p>"
	            + "<p>You have requested to reset your password.</p>"
	            + "<p>Click the link below to change your password:</p>"
	            + "<p><a href=\"" + link + "\">Change my password</a></p>"
	            + "<br>"
	            + "<p>Ignore this email if you do remember your password, "
	            + "or you have not made the request.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	}
}
