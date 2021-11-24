package com.hybrid.service;

import java.util.List;

import com.hybrid.request.PostRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.response.PostResponse;

public interface IPostService {
	
	List<PostResponse> getHomePost();

	List<PostResponse> getPost();

	BaseResponse save(PostRequest postRequest, String image);
}
