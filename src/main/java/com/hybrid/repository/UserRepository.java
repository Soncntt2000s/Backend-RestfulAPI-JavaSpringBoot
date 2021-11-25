package com.hybrid.repository;

import com.hybrid.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hybrid.entity.UserEntity;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	UserEntity findOneByEmail(String email);
	
	UserEntity findOneById(Integer integer);

	Boolean existsByEmail(String email);

	List<CommentEntity> findDistinctById(Integer id);

}
