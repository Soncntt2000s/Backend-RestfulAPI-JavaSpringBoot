package com.hybrid.service;

import java.util.List;

import com.hybrid.response.HomePostResponse;

public interface IPostService {
	
	List<HomePostResponse> getHomePost();
}
