package com.hybrid.response;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PostResponse {
	
	private String createBy;
	
	private String title;
	
	private String miniText;
	
	private String image;
	
	private Timestamp createAt;
	
	private String category;
	
	private String content;
	
	private int likeNumber;
	
	private int viewNumber;
}
