package com.hybrid.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hybrid.entity.BranchEntity;
import com.hybrid.entity.CategoryEntity;
import com.hybrid.entity.PostEntity;
import com.hybrid.entity.UserEntity;
import com.hybrid.request.BranchRequest;
import com.hybrid.request.PostRequest;
import com.hybrid.response.CommentResponse;
import com.hybrid.response.PostDetailResponse;
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
	
	public PostDetailResponse toPostDetailResponse(PostEntity entity, List<CommentResponse> listCommentResponse)
	{
		PostDetailResponse postDetailResponse = new PostDetailResponse();
		postDetailResponse.setCategory(entity.getCategory().getName());
		postDetailResponse.setContent(entity.getContent());
		postDetailResponse.setCreateAt(entity.getCreatedAt());
		postDetailResponse.setCreateBy(entity.getUser().getUserProfile().getFullname());
		postDetailResponse.setImage(entity.getUrlImg());
		postDetailResponse.setLikeNumber(entity.getListUser().size());
		postDetailResponse.setListCommentResponse(listCommentResponse);
		postDetailResponse.setMiniText(entity.getMiniText());
		postDetailResponse.setTitle(entity.getTitle());
		postDetailResponse.setViewNumber(entity.getViewNumber());
		return postDetailResponse;
	}
}
