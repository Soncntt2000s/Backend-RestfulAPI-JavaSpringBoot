package com.hybrid.converter;

import org.springframework.stereotype.Component;

import com.hybrid.entity.CommentEntity;
import com.hybrid.response.CommentResponse;

@Component
public class CommentConverter {
	
	public CommentResponse toCommentResponse(CommentEntity entity)
	{
		CommentResponse commentResponse = new CommentResponse();
		commentResponse.setId(entity.getId());
		commentResponse.setContent(entity.getContent());
		commentResponse.setCreateAt(entity.getCreatedAt());
		commentResponse.setCreateBy(entity.getUser().getUserProfile().getFullname());
		commentResponse.setCommentParentId(entity.getListCommentParent());
		commentResponse.setLikeNumber(entity.getLikeNumber());
		return commentResponse;
	}
	
}
