package com.hybrid.repository;

import com.hybrid.common.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.RoleEntity;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{

	RoleEntity findByName(String name);

	Optional<RoleEntity> findOneByName(ERole name);
	
}
