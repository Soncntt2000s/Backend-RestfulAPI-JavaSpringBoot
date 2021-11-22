package com.hybrid.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "forgot_password")
public class ForgotPasswordEntity{	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email",columnDefinition = "varchar(255) NOT NULL",unique = true)
    private String email;

    @Column(name = "token",columnDefinition = "varchar(255) NOT NULL")
    private String token;

    @Column(name = "created_at",columnDefinition = "timestamp default CURRENT_TIMESTAMP()")
    private Timestamp createdAt;
	

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}
	
}
