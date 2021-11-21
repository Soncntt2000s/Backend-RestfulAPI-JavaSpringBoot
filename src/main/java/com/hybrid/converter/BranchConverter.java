package com.hybrid.converter;

import org.springframework.stereotype.Component;

import com.hybrid.entity.BranchEntity;
import com.hybrid.request.BranchRequest;
import com.hybrid.response.BranchResponse;

@Component
public class BranchConverter {
	
	public BranchResponse toBranhResponse(BranchEntity entity)
	{
		BranchResponse branchResponse = new BranchResponse();
		branchResponse.setId(entity.getId());
		branchResponse.setName(entity.getName());
		branchResponse.setDescription(entity.getDescription());
		branchResponse.setCreatedAt(entity.getCreatedAt());
		branchResponse.setUpdatedAt(entity.getUpdatedAt());
		return branchResponse;
	}
	
	public BranchEntity toCreateBranhEntity(BranchRequest createBranchRequest)
	{
		BranchEntity branchEntity = new BranchEntity();
		branchEntity.setName(createBranchRequest.getName());
		branchEntity.setDescription(createBranchRequest.getDescription());
		return branchEntity;
	}

	public BranchEntity toUpdateBranhEntity(BranchRequest branchRequest, Integer id)
	{
		BranchEntity branchEntity = new BranchEntity();
		branchEntity.setName(branchRequest.getName());
		branchEntity.setDescription(branchRequest.getDescription());
		branchEntity.setId(id);
		return branchEntity;
	}
}
