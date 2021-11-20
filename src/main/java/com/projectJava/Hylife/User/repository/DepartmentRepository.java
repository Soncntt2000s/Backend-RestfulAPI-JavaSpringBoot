package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.entity.Departments;
import com.projectJava.Hylife.User.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments,Integer> {
}
