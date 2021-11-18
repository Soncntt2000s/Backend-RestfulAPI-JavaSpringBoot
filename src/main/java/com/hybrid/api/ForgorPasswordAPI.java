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
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.entity.ForgotPasswordEntity;
import com.hybrid.entity.UserEntity;
import com.hybrid.request.ForgetPasswordRequest;
import com.hybrid.request.PasswordRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.service.impl.UserService;

import net.bytebuddy.utility.RandomString;

@RestController
public class ForgorPasswordAPI {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/forgot_password")
	public BaseResponse ForgotPassword(@Valid @RequestBody ForgetPasswordRequest emailDTO) {
	    String email = emailDTO.getEmail();
	    String token = RandomString.make(30);
	    return userService.forgotPassword(token, email);
	}
	
	@PostMapping("/api/reset_password")
	public BaseResponse processResetPassword(@Valid @RequestBody PasswordRequest passRequest) {
		return userService.updatePassword(passRequest);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public BaseResponse handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
		BaseResponse baseDTO = new BaseResponse();
	    baseDTO.setReponseCode(400);
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	        baseDTO.setMessage(errorMessage);
	    });
	    return baseDTO;
	}
	
	//xem lại
}
