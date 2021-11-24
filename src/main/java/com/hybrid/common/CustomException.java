package com.hybrid.common;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hybrid.response.BaseResponse;

@RestControllerAdvice
public class CustomException{
	
	
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public BaseResponse loginFalse() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("tài khoản hoặc mk sai");
        baseResponse.setReponseCode(400);
        return baseResponse;
    }
    
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public BaseResponse Role(AuthenticationException ex) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("tài khoản hoặc mk sai");
        baseResponse.setReponseCode(400);
        return baseResponse;
    }
    
    
	//Đoạn code này dùng để bắt lỗi valid request
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public BaseResponse handleValidationExceptions(
		  MethodArgumentNotValidException ex) {
			BaseResponse baseDTO = new BaseResponse();
		    baseDTO.setReponseCode(401);
		    //Map<String, String> errors = new HashMap<>();
//		    ex.getBindingResult().getAllErrors().forEach((error) -> {
//		        //String fieldName = ((FieldError) error).getField();
//		        String errorMessage = error.getDefaultMessage();
//		        //errors.put(fieldName, errorMessage);
//		        baseDTO.setMessage(errorMessage);
//		    });
		    baseDTO.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
		    return baseDTO;
		}
	
}
