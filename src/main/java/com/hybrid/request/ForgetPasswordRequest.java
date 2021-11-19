package com.hybrid.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForgetPasswordRequest {
	@NotEmpty(message = "email không được để trống")
	@Email(message = "Email không đúng định dạng")
	@Length(max = 255, message = "Email không được dài hơn 255 ký tự")
	private String email;

	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
}
