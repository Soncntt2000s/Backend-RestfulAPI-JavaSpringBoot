package com.hybrid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, Integer>{
	
	List<BranchEntity> findAll();
	
	BranchEntity findOneById(Integer id);
	
}
