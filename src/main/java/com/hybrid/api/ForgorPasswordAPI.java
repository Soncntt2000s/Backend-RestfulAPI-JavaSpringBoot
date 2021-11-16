package com.hybrid.api;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.dto.BaseDTO;
import com.hybrid.dto.EmailDTO;
import com.hybrid.dto.NewPasswordDTO;
import com.hybrid.entity.ForgotPasswordEntity;
import com.hybrid.entity.UserEntity;
import com.hybrid.service.impl.UserService;

import net.bytebuddy.utility.RandomString;

@RestController
public class ForgorPasswordAPI {
	
	@Autowired
    private JavaMailSender mailSender;

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/forgot_password")
	public BaseDTO processForgotPassword(@Valid @RequestBody EmailDTO emailDTO) {
		BaseDTO baseDTO = new BaseDTO();
	    String email = emailDTO.getEmail();
	    String token = RandomString.make(30);
	    if(userService.updateResetPasswordToken(token, email)==1)
	    {
	        String resetPasswordLink = "/reset_password?token=" + token;
	        try {
				sendEmail(email, resetPasswordLink);
			} catch (UnsupportedEncodingException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        baseDTO.setreponse_code(200);
    		baseDTO.setMessage("Email comfirmation succesfull, check email");
	    }
	    else
	    {
	    	baseDTO.setreponse_code(401);
    		baseDTO.setMessage("Email is empty. Please input the email");
	    }
	    return baseDTO;
	}
	
	@PostMapping("/api/reset_password")
	public BaseDTO processResetPassword(@Valid @RequestBody NewPasswordDTO newPass) {
		BaseDTO baseDTO = new BaseDTO();
		String token = newPass.getToken();
	    String newPassword = newPass.getNewPassword();
	    String confirmPass = newPass.getConfirmNewPassword();
	    if(newPassword .equals(confirmPass))
	    {
	    	ForgotPasswordEntity forgotPass = userService.getByResetPasswordToken(token);
	    	if (forgotPass == null) {
		        baseDTO.setreponse_code(401);
	    		baseDTO.setMessage("Not find email");
		    } else {
		    	UserEntity userEntity = userService.getUser(forgotPass.getEmail());
		        userService.updatePassword(userEntity, newPassword);
		        baseDTO.setreponse_code(200);
	    		baseDTO.setMessage("Reset password successfully!");
		    }
	    }
	    else
	    {
	    	baseDTO.setreponse_code(400);
    		baseDTO.setMessage("Confirm new password doesn't not match new password!");
	    }
	     
//	    Customer customer = customerService.getByResetPasswordToken(token);
//	    model.addAttribute("title", "Reset your password");
//	     
//	    if (customer == null) {
//	        model.addAttribute("message", "Invalid Token");
//	        return "message";
//	    } else {           
//	        customerService.updatePassword(customer, password);
//	         
//	        model.addAttribute("message", "You have successfully changed your password.");
//	    }
//	     
//	    return "message";
	    return baseDTO;
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
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public BaseDTO handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
		BaseDTO baseDTO = new BaseDTO();
	    baseDTO.setreponse_code(400);
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	        baseDTO.setMessage(errorMessage);
	    });
	    return baseDTO;
	}
}
