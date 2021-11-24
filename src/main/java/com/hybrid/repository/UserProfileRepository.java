package com.hybrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.UserProfileEntity;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Integer>{
	
	UserProfileEntity findOneByUserId(Integer integer);
	
}
