package com.hybrid.request;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class ResetPasswordRequest {
	
	@Length(min = 8, max = 255, message = "new password length between 8 and 255")
	@NotEmpty(message = "Please input new password")
	private String password;
	
	@Length(min = 8, max = 255, message = "confirm password length between 8 and 255")
	@NotEmpty(message = "Please input confirm password")
	private String confirmPassword;
	
	private String token;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
