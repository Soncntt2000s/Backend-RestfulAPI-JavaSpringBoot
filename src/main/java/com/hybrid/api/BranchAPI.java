package com.hybrid.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.entity.BranchEntity;
import com.hybrid.repository.BranchRepository;
import com.hybrid.request.BranchRequest;
import com.hybrid.response.BaseDataResponse;
import com.hybrid.response.BaseResponse;
import com.hybrid.response.BranchResponse;
import com.hybrid.service.IBranchService;


@RestController
public class BranchAPI {
	
	@Autowired
	private IBranchService branchService;
	
	@Autowired
	private BranchRepository branchRepo;
	
	@GetMapping(value = "/api/admin/branch")
	public BaseDataResponse< List<BranchResponse>> getBranch() {
		BaseDataResponse< List<BranchResponse>> baseListBranch = new BaseDataResponse< List<BranchResponse>>();
			baseListBranch.setReponseCode(200);
			baseListBranch.setMessage("Get branch successfully");
			baseListBranch.setData(branchService.getBranch());
		return baseListBranch;
	}
	
	@PostMapping(value = "/api/admin/branch")
	public BaseResponse createBranch(@RequestBody BranchRequest branchRequest)
	{
		return branchService.save(branchRequest);
	}
	
	@PutMapping(value = "/api/admin/branch/{id}")
	public BaseResponse updateBranch(@RequestBody BranchRequest banchRequest, @PathVariable Integer id)
	{
		return branchService.update(banchRequest, id);
	}
	
	@DeleteMapping(value = "/api/admin/branch/{id}")
	public BaseResponse deleteBranch(@PathVariable Integer id)
	{
		branchRepo.deleteById(id);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setReponseCode(200);
		baseResponse.setMessage("delete successfully");
		return baseResponse;
	}
}
