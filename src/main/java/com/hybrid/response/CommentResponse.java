package com.hybrid.response;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentResponse {
	
	private Integer id;
	
	private Integer commentParentId;
	
	private Timestamp createAt;
	
	private String content;
	
	private int likeNumber;
	
	private String createBy;
	
}
