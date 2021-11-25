package com.hybrid.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hybrid.converter.BranchConverter;
import com.hybrid.entity.BranchEntity;
import com.hybrid.request.CategoryRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybrid.converter.CategoryConverter;
import com.hybrid.entity.CategoryEntity;
import com.hybrid.repository.CategoryRepository;
import com.hybrid.response.HomeCategoryResponse;
import com.hybrid.service.ICategoryService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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

	@Override
	public List<CategoryResponse> getAllCategory() {
		List<CategoryResponse> listCategoryResponse = new ArrayList<>();
		List<CategoryEntity> listCategoryEntity = categoryRepo.findAll();
		listCategoryEntity.forEach((categoryEntity)-> {
			listCategoryResponse.add(categoryConverter.toGetAllCategoryEntity(categoryEntity));
		});
		return listCategoryResponse;
	}


	@Override
	public BaseResponse saveCategory(CategoryRequest categoryRequest) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity = categoryConverter.toCreateCategoryEntity(categoryRequest);
		categoryRepo.save(categoryEntity);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setReponseCode(200);
		baseResponse.setMessage("Create category successfully");
		return baseResponse;
	}

	@Override
	public BaseResponse updateCategory(CategoryRequest categoryRequest, Integer id) {
		BaseResponse baseResponse = new BaseResponse();
		CategoryEntity categoryEntity = new CategoryEntity();
		CategoryEntity oldCategoryEntity = categoryRepo.findOneById(id);
		if (oldCategoryEntity == null) {
			baseResponse.setReponseCode(400);
			baseResponse.setMessage("Category does not exist");
		} else {
			categoryEntity = categoryConverter.toUpdateCategoryEntity(oldCategoryEntity,categoryRequest);
			categoryRepo.save(categoryEntity);
			baseResponse.setReponseCode(200);
			baseResponse.setMessage("Update category successfully");
		}
		return baseResponse;
	}

	@Override
	public void deleteCategory(Integer id) {
		 categoryRepo.deleteById(id);
	}


}
