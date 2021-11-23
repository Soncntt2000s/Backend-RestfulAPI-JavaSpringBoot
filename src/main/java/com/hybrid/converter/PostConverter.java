package com.hybrid.converter;

import org.springframework.stereotype.Component;

import com.hybrid.entity.PostEntity;
import com.hybrid.response.HomePostResponse;

@Component
public class PostConverter {

	public HomePostResponse toHomePostResponse(PostEntity entity)
	{
		HomePostResponse homePostResponse = new HomePostResponse();
		homePostResponse.setTitle(entity.getTitle());
		homePostResponse.setMiniText(entity.getMiniText());
		homePostResponse.setImage(entity.getUrlImg());
		homePostResponse.setCreateAt(entity.getCreatedAt());
		homePostResponse.setCategory(entity.getCategory().getName());
		return homePostResponse;
	}
	
}
