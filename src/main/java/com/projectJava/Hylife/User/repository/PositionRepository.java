package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.common.ERole;
import com.projectJava.Hylife.User.entity.Departments;
import com.projectJava.Hylife.User.entity.Positions;
import com.projectJava.Hylife.User.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PositionRepository extends JpaRepository<Positions,Integer> {

    /**
     * Find role by name
     * @return Positions
     */
    Positions findByName(String name);

}
