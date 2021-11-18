package com.projectJava.Hylife.User.Repository;

import com.projectJava.Hylife.User.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
}
