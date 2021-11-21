package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.common.ERole;
import com.projectJava.Hylife.User.entity.Branchs;
import com.projectJava.Hylife.User.entity.Departments;
import com.projectJava.Hylife.User.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface BranchRepository extends JpaRepository<Branchs,Integer> {

    /**
     * Find role by name
     * @return Branch
     */
    Branchs findByName(String name);

}
