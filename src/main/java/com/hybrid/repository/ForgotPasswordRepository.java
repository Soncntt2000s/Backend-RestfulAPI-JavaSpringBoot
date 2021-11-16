package com.hybrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.ForgotPasswordEntity;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordEntity, String>{
	
	public ForgotPasswordEntity findOneByToken(String token);
}
