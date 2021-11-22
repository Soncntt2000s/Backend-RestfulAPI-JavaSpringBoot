package com.hybrid.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.repository.CategoryRepository;
import com.hybrid.response.BaseDataResponse;
import com.hybrid.response.HomeCategoryResponse;
import com.hybrid.service.ICategoryService;

@RestController
public class CategoryAPI {
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping(value = "/api/home-category")
	public BaseDataResponse< List<HomeCategoryResponse>> getBranch() {
		BaseDataResponse< List<HomeCategoryResponse>> baseListBranch = new BaseDataResponse< List<HomeCategoryResponse>>();
			baseListBranch.setReponseCode(200);
			baseListBranch.setMessage("Get branch successfully");
			baseListBranch.setData(categoryService.getHomeCategory());
		return baseListBranch;
	}
}
