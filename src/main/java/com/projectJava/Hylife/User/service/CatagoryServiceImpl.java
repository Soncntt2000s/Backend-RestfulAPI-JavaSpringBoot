package com.projectJava.Hylife.User.service;

import com.projectJava.Hylife.User.entity.Catagories;
import com.projectJava.Hylife.User.repository.CatagoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CatagoryServiceImpl implements CatagoriesService{

    @Autowired
    CatagoriesRepository catagoriesRepository;


    @Override
    public List<Catagories> getAllCategory() {
        List<Catagories> listCategory =   catagoriesRepository.findAll();
        return listCategory;
    }
}
