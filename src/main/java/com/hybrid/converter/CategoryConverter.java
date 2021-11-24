package com.hybrid.converter;

import com.hybrid.entity.BranchEntity;
import com.hybrid.request.BranchRequest;
import com.hybrid.request.CategoryRequest;
import org.springframework.stereotype.Component;

import com.hybrid.entity.CategoryEntity;
import com.hybrid.response.HomeCategoryResponse;

import java.util.Set;

@Component
public class CategoryConverter {
	public HomeCategoryResponse toHomeCategoryResponse(CategoryEntity entity)
	{
		HomeCategoryResponse homeCategoryResponse = new HomeCategoryResponse();
		homeCategoryResponse.setId(entity.getId());
		homeCategoryResponse.setName(entity.getName());
		homeCategoryResponse.setSlug(entity.getSlug());
		homeCategoryResponse.setCategoryParentId(entity.getCategoryParentId());
		return homeCategoryResponse;
	}

	public CategoryEntity toCreateCategoryEntity(CategoryRequest categoryRequest)
	{
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName(categoryRequest.getName());
		categoryEntity.setSlug(categoryRequest.getSlug());
		categoryEntity.setCategoryParentId(categoryRequest.getCategoryParentId());
		categoryEntity.setCreatedAt(categoryRequest.getCreatedAt());
		categoryEntity.setUpdatedAt(categoryRequest.getUpdatedAt());
		return categoryEntity;
	}

	public CategoryEntity toUpdateCategoryEntity(CategoryEntity categoryEntity, CategoryRequest categoryRequest)
	{
		categoryEntity.setName(categoryRequest.getName());
		categoryEntity.setCategoryParentId(categoryRequest.getCategoryParentId());
		categoryEntity.setSlug(categoryRequest.getSlug());
		return categoryEntity;
	}
}
