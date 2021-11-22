package com.hybrid.request;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class ChangePasswordRequest {
	
	@NotEmpty(message = "Please input current password")
	private String currentPassword;
	
	@Length(min = 8, max = 255, message = "new password length between 8 and 255")
	@NotEmpty(message = "Please input new password")
	private String newPassword;
	
	@Length(min = 8, max = 255, message = "new password length between 8 and 255")
	@NotEmpty(message = "Please input confirm password")
	private String confirmNewPassword;
}
