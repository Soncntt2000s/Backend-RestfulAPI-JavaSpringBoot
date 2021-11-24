package com.hybrid.api;

import java.util.List;

import com.hybrid.entity.CategoryEntity;
import com.hybrid.request.CategoryRequest;
import com.hybrid.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	@GetMapping(value = "/api/categories/get")
	public BaseDataResponse< List<HomeCategoryResponse>> getBranch() {
		BaseDataResponse< List<HomeCategoryResponse>> baseListBranch = new BaseDataResponse< List<HomeCategoryResponse>>();
			baseListBranch.setReponseCode(200);
			baseListBranch.setMessage("Get Category successfully");
			baseListBranch.setData(categoryService.getHomeCategory());
		return baseListBranch;
	}

	@PostMapping("/api/admin/category")
	public BaseResponse createCategory(@RequestBody CategoryRequest categoryRequest){
		return categoryService.saveCategory(categoryRequest);
	}

	@PutMapping("/api/admin/category/{id}")
	public BaseResponse updateCategory(@RequestBody CategoryRequest categoryRequest,@PathVariable Integer id){
		return categoryService.updateCategory(categoryRequest,id);
	}

	@DeleteMapping(value = "/api/admin/category/{id}")
	public BaseResponse deleteBranch(@PathVariable(value = "id") Integer id)
	{
		categoryService.deleteCategory(id);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setReponseCode(200);
		baseResponse.setMessage("delete successfully");
		return baseResponse;
	}

}
