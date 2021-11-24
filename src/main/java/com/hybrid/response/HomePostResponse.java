package com.hybrid.response;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class HomePostResponse {
	
	private String title;
	
	private String miniText;
	
	private String image;
	
	private Timestamp createAt;
	
	private String category;
	
}
