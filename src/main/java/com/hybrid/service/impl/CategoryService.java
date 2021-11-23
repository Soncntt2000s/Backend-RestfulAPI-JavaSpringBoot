package com.hybrid.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybrid.converter.BranchConverter;
import com.hybrid.converter.CategoryConverter;
import com.hybrid.entity.BranchEntity;
import com.hybrid.entity.CategoryEntity;
import com.hybrid.repository.BranchRepository;
import com.hybrid.repository.CategoryRepository;
import com.hybrid.response.BranchResponse;
import com.hybrid.response.HomeCategoryResponse;
import com.hybrid.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<HomeCategoryResponse> getHomeCategory() {
		List<HomeCategoryResponse> listHomeCategoryResponse = new ArrayList<>();
		List<CategoryEntity> listCategoryEntity = categoryRepo.findAll();
		listCategoryEntity.forEach((categoryEntity) -> {
			listHomeCategoryResponse.add(categoryConverter.toHomeCategoryResponse(categoryEntity));
        });
		return listHomeCategoryResponse;
	}
}
