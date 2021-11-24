package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments,Integer> {


    /**
     * Find role by name
     * @return Departments
     */
    Departments findByName(String name);

}
