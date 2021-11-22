package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.entity.Catagories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatagoriesRepository extends JpaRepository<Catagories,Integer> {
}
