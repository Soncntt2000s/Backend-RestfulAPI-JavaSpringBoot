package com.hybrid.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForgetPasswordRequest {
	@NotEmpty(message = "Please input email")
	@Email(message = "Please input the correct email format")
	@Length(max = 255, message = "Please input email max 255 characters")
	private String email;

	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
}
