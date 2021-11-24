package com.hybrid.response;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class PostDetailResponse {
	
	private String createBy;
	
	private String title;
	
	private String miniText;
	
	private String image;
	
	private Timestamp createAt;
	
	private String category;
	
	private String content;
	
	private int likeNumber;
	
	private int viewNumber;
	
	List<CommentResponse> listCommentResponse;
	
}	
