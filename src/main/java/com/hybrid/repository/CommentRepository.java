package com.hybrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{

}
