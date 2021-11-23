package com.hybrid.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybrid.converter.BranchConverter;
import com.hybrid.entity.BranchEntity;
import com.hybrid.repository.BranchRepository;
import com.hybrid.request.BranchRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.response.BranchResponse;
import com.hybrid.service.IBranchService;

@Service
public class BranchService implements IBranchService {

	@Autowired
	private BranchRepository branchRepo;

	@Autowired
	private BranchConverter branchConverter;

	@Override
	public List<BranchResponse> getBranch() {
		List<BranchResponse> listBranchResponse = new ArrayList<>();
		List<BranchEntity> listBranchEntity = branchRepo.findAll();
		listBranchEntity.forEach((branchEntity) -> {
			listBranchResponse.add(branchConverter.toBranhResponse(branchEntity));
		});
		return listBranchResponse;
	}

	@Override
	public BaseResponse save(BranchRequest BranchRequest) {
		BranchEntity branchEntity = new BranchEntity();
		branchEntity = branchConverter.toCreateBranhEntity(BranchRequest);
		branchRepo.save(branchEntity);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setReponseCode(200);
		baseResponse.setMessage("Create branch successfully");
		return baseResponse;
	}

	@Override
	public BaseResponse update(BranchRequest BranchRequest, Integer id) {
		BaseResponse baseResponse = new BaseResponse();
		BranchEntity branchEntity = new BranchEntity();
		BranchEntity oldBranchEntity = branchRepo.findOneById(id);
		if (oldBranchEntity == null) {
			baseResponse.setReponseCode(400);
			baseResponse.setMessage("Branch does not exist");
		} else {
			branchEntity = BranchConverter.toUpdateEntity(BranchRequest, oldBranchEntity);
			branchRepo.save(branchEntity);
			baseResponse.setReponseCode(200);
			baseResponse.setMessage("Update branch successfully");
		}
		return baseResponse;
	}

}
