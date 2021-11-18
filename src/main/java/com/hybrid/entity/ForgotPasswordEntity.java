package com.hybrid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "forgot_password")
public class ForgotPasswordEntity extends BaseEntity{
	
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String email;
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String token;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
