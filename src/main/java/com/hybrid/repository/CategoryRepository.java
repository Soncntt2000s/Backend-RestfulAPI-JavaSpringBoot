package com.hybrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{

	CategoryEntity findOneById(Integer integer);
	
}
