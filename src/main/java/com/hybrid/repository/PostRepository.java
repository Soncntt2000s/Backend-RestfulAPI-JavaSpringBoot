package com.hybrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer>{

}
