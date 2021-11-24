package com.hybrid.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybrid.converter.PostConverter;
import com.hybrid.entity.PostEntity;
import com.hybrid.repository.PostRepository;
import com.hybrid.response.HomePostResponse;
import com.hybrid.service.IPostService;

@Service
public class PostService implements IPostService{

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private PostConverter postConverter;
	
	@Override
	public List<HomePostResponse> getHomePost() {
		List<HomePostResponse> listHomePostResponse = new ArrayList<>();
		List<PostEntity> listPostEntity = postRepo.findTop2ByOrderByCreatedAtDesc();
		listPostEntity.forEach((postEntity) -> {
			listHomePostResponse.add(postConverter.toHomePostResponse(postEntity));
        });
		return listHomePostResponse ;
	}

}
