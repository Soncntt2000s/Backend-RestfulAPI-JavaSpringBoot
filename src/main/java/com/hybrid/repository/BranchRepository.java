package com.hybrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, Integer>{

}
