package com.hybrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	UserEntity findOneByEmail(String email);
	
	UserEntity findOneById(Integer integer);

	Boolean existsByEmail(String email);

}
