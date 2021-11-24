package com.hybrid.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hybrid.converter.CommentConverter;
import com.hybrid.converter.PostConverter;
import com.hybrid.entity.BranchEntity;
import com.hybrid.entity.CategoryEntity;
import com.hybrid.entity.CommentEntity;
import com.hybrid.entity.PostEntity;
import com.hybrid.entity.UserEntity;
import com.hybrid.repository.CategoryRepository;
import com.hybrid.repository.PostRepository;
import com.hybrid.repository.UserRepository;
import com.hybrid.request.BranchRequest;
import com.hybrid.request.PostRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.response.CommentResponse;
import com.hybrid.response.PostDetailResponse;
import com.hybrid.response.PostResponse;
import com.hybrid.service.IPostService;

@Service
public class PostService implements IPostService{

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private PostConverter postConverter;
	
	@Autowired
	private CommentConverter commentConverter;
	
	@Override
	public List<PostResponse> getHomePost() {
		List<PostResponse> listHomePostResponse = new ArrayList<>();
		List<PostEntity> listPostEntity = postRepo.findTop5ByOrderByCreatedAtDesc();
		listPostEntity.forEach((postEntity) -> {
			listHomePostResponse.add(postConverter.toHomePostResponse(postEntity));
        });
		return listHomePostResponse ;
	}
	
	@Override
	public List<PostResponse> getPost() {
		List<PostResponse> listHomePostResponse = new ArrayList<>();
		List<PostEntity> listPostEntity = postRepo.findTop12ByOrderByCreatedAtDesc();
		listPostEntity.forEach((postEntity) -> {
			listHomePostResponse.add(postConverter.toHomePostResponse(postEntity));
        });
		return listHomePostResponse ;
	}
	
	@Override
	public BaseResponse save(PostRequest postRequest, String image) {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserEntity userEntity = userRepo.findOneById(userDetail.getId());
		CategoryEntity catEntity = catRepo.findOneById(postRequest.getCategoryId());
		PostEntity postEntity = new PostEntity();
		postEntity = postConverter.toPostEntity(postRequest, userEntity, catEntity, image);
		postRepo.save(postEntity);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setReponseCode(200);
		baseResponse.setMessage("Create branch successfully");
		return baseResponse;
	}
	
	@Override
	public PostDetailResponse getPostDetail(Integer id) {
		PostEntity postEntity = postRepo.findOneById(id);
		List<CommentResponse> listCommentResponse = new ArrayList<>();
		postEntity.getListComment().forEach((commentEntity) -> {
			listCommentResponse.add(commentConverter.toCommentResponse(commentEntity));
        });
		PostDetailResponse postDetailResponse = postConverter.toPostDetailResponse(postEntity, listCommentResponse);
		return postDetailResponse ;
	}

}
