package com.hybrid.service;

import java.util.List;

import com.hybrid.entity.BranchEntity;
import com.hybrid.request.BranchRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.response.BranchResponse;

public interface IBranchService {
	
	List<BranchResponse> getBranch();

	BaseResponse save(BranchRequest branchRequest);

	BaseResponse update(BranchRequest branchRequest, Integer id);

}
