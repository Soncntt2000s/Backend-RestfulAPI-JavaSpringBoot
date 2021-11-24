package com.projectJava.Hylife.User.repository;

import com.projectJava.Hylife.User.entity.Banners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BannerRepository extends JpaRepository<Banners,Integer> {

    Banners findOneById(Integer id);

    List<Banners> findAll();

    Optional<Banners> findById(Integer id);

    Banners getById(Integer id);

    void deleteById(Integer id);
}
