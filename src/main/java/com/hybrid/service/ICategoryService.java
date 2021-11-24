package com.hybrid.service;

import java.util.List;

import com.hybrid.response.BranchResponse;
import com.hybrid.response.HomeCategoryResponse;

public interface ICategoryService {
	List<HomeCategoryResponse> getHomeCategory();
}
