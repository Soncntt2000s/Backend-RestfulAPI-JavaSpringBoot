package com.hybrid.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginRequest {
	
	@NotEmpty(message = "email không được để trống")
	@Email(message = "Email không đúng định dạng")
	private String email;
	
	@NotEmpty(message = "password không được để trống")
    private String password;
}
