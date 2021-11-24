package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.entity.Roles;
import com.projectJava.Hylife.User.common.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {

    /**
     * Find role by name
     * @return Roles
     */
    Optional<Roles> findByName(ERole name);

    /**
     * Find role by name
     * @return Roles
     */
    Optional<Roles> findById(Integer id);

}
