package com.hybrid.repository;

import com.hybrid.entity.BannersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannersRepository extends JpaRepository<BannersEntity,Integer>{

    List<BannersEntity> findAll();
}
