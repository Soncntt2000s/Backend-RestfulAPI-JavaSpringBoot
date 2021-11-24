package com.hybrid.converter;

import org.springframework.stereotype.Component;

import com.hybrid.entity.BranchEntity;
import com.hybrid.entity.CategoryEntity;
import com.hybrid.entity.PostEntity;
import com.hybrid.entity.UserEntity;
import com.hybrid.request.BranchRequest;
import com.hybrid.request.PostRequest;
import com.hybrid.response.PostResponse;

@Component
public class PostConverter {

	public PostResponse toHomePostResponse(PostEntity entity)
	{
		PostResponse homePostResponse = new PostResponse();
		homePostResponse.setTitle(entity.getTitle());
		homePostResponse.setMiniText(entity.getMiniText());
		homePostResponse.setImage(entity.getUrlImg());
		homePostResponse.setCreateAt(entity.getCreatedAt());
		homePostResponse.setCategory(entity.getCategory().getName());
		homePostResponse.setContent(entity.getContent());
		homePostResponse.setCreateBy(entity.getUser().getUserProfile().getFullname());
		homePostResponse.setViewNumber(entity.getViewNumber());
		homePostResponse.setLikeNumber(entity.getListUser().size());
		return homePostResponse;
	}
	
	public PostEntity toPostEntity(PostRequest postRequest, UserEntity userEntity, CategoryEntity catEntity, String image)
	{
		PostEntity postEntity = new PostEntity();
		postEntity.setCategory(catEntity);
		postEntity.setContent(postRequest.getContent());
		postEntity.setTitle(postRequest.getTitle());
		postEntity.setMiniText(postRequest.getMiniText());
		postEntity.setUrlImg(image);
		postEntity.setUser(userEntity);
		return postEntity;
	}
	
}
