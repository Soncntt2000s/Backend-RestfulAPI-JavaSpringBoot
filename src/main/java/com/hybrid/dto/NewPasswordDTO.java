package com.hybrid.dto;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class NewPasswordDTO {
	
	@Length(min = 8, max = 255, message = "new password length between 8 and 255")
	@NotEmpty(message = "Please input new password")
	private String newPassword;
	
	@Length(min = 8, max = 255, message = "confirm password length between 8 and 255")
	@NotEmpty(message = "Please input confirm password")
	private String confirmNewPassword;
	
	private String token;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
