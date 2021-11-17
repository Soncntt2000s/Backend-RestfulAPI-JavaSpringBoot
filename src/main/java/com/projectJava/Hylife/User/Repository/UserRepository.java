package com.projectJava.Hylife.User.Repository;

import com.projectJava.Hylife.User.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{

    /**
     * Find email by email user
     * @return Users
     */
    Optional<Users> findByEmail(String email);

    /**
     * Check exists an user email
     * @return Boolean
     */
    Boolean existsByEmail(String email);
}
