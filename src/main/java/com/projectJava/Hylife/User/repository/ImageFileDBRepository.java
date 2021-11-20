package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.entity.FileImageDB;
import com.projectJava.Hylife.User.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageFileDBRepository extends JpaRepository<FileImageDB,String> {
}
