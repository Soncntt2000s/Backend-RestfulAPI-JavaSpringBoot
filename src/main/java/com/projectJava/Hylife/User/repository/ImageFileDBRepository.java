package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.entity.FileImageDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageFileDBRepository extends JpaRepository<FileImageDB,String> {

    Optional<FileImageDB> findById(String id);

}
