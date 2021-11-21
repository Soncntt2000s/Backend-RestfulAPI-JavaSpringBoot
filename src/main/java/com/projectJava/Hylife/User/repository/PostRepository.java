package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts , Integer> {
}
