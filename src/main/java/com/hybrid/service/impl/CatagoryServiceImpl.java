package com.hybrid.service.impl;

import com.hybrid.entity.CategoryEntity;
import com.hybrid.service.CatagoriesService;
import com.hybrid.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CatagoryServiceImpl implements CatagoriesService {

    @Autowired
    CategoryRepository catagoriesRepository;


    @Override
    public List<CategoryEntity> getAllCategory() {
        List<CategoryEntity> listCategory =   catagoriesRepository.findAll();
        return listCategory;
    }
}
