package com.hybrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{

	RoleEntity findByName(String name);
	
}
