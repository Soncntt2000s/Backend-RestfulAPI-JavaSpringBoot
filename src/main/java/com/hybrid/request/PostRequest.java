package com.hybrid.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PostRequest {
	
	private Integer categoryId;
	
	private String title;
	
	private MultipartFile image;
	
	private String content;
	
	private String miniText;
	
}
