package com.hybrid.response;

import com.hybrid.entity.CategoryEntity;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class HomeCategoryResponse {
	
	private Integer id;

	private Integer categoryParentId;
	
	private String name;
	
	private String slug;
	
}
