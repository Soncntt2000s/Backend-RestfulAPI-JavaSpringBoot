package com.hybrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.PositionEntity;

public interface PositionRepository extends JpaRepository<PositionEntity, Integer>{
    PositionEntity findByName(String name);
}
