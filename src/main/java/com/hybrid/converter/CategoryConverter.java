package com.hybrid.converter;

import org.springframework.stereotype.Component;

import com.hybrid.entity.CategoryEntity;
import com.hybrid.response.HomeCategoryResponse;

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
}
