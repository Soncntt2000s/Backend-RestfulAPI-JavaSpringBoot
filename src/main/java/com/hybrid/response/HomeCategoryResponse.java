package com.hybrid.response;

import lombok.Data;

@Data
public class HomeCategoryResponse {
	
	private Integer id;
	
	private Integer categoryParentId;
	
	private String name;
	
	private String slug;
	
}
