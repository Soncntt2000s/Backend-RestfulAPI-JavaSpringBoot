package com.hybrid.repository;

import com.hybrid.response.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.CommentEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{

    List<CommentEntity> findAllByPostId(Integer id);

    CommentEntity findByPostIdAndContent(Integer id,String content);

    CommentEntity getCommentEntityById(Integer id);

    CommentEntity findByPostId(Integer id);

    CommentEntity findByPostIdAndUserId(Integer id , Integer id1);
}
