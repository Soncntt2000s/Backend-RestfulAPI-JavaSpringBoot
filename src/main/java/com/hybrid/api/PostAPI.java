package com.hybrid.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.repository.PostRepository;
import com.hybrid.response.BaseDataResponse;
import com.hybrid.response.HomePostResponse;
import com.hybrid.service.IPostService;

@RestController
public class PostAPI {
	
	@Autowired
	private IPostService postService;
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping(value = "/api/home-post")
	public BaseDataResponse<List<HomePostResponse>> getHomePost()
	{
		BaseDataResponse< List<HomePostResponse>> baseListHomePost = new BaseDataResponse< List<HomePostResponse>>();
		baseListHomePost.setReponseCode(200);
		baseListHomePost.setMessage("Get post successfully");
		baseListHomePost.setData(postService.getHomePost());
		return baseListHomePost;
	}
	//@GetMapping(value = "api/post/news")
}
