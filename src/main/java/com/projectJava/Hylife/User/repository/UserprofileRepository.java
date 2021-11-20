package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.entity.UserProfile;
import com.projectJava.Hylife.User.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserprofileRepository extends JpaRepository<UserProfile,Integer > {

}
