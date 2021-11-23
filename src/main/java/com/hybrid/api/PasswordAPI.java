package com.hybrid.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.request.ChangePasswordRequest;
import com.hybrid.request.ForgetPasswordRequest;
import com.hybrid.request.ResetPasswordRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.service.impl.UserService;

import net.bytebuddy.utility.RandomString;

@RestController
public class PasswordAPI {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/forgot_password")
	public BaseResponse forgotPassword(@Valid @RequestBody ForgetPasswordRequest emailRequest) {
	    String email = emailRequest.getEmail();
	    String token = RandomString.make(30);
	    return userService.forgotPassword(token, email);
	}
	
	@PostMapping("/api/reset_password")
	public BaseResponse resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
		return userService.resetPassword(resetPasswordRequest);
	}
	
	@PostMapping("/api/change_password")
	public BaseResponse changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
		return userService.changePassword(changePasswordRequest);
	}
	
	
	//Đoạn code này dùng để bắt lỗi valid request
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public BaseResponse handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
		BaseResponse baseDTO = new BaseResponse();
	    baseDTO.setReponseCode(401);
	    //Map<String, String> errors = new HashMap<>();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        //String fieldName = ((FieldError) error).getField();
//	        String errorMessage = error.getDefaultMessage();
//	        //errors.put(fieldName, errorMessage);
//	        baseDTO.setMessage(errorMessage);
//	    });
	    baseDTO.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
	    return baseDTO;
	}
}
