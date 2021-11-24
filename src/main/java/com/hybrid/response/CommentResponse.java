package com.hybrid.response;

import java.sql.Timestamp;
import java.util.List;

import com.hybrid.entity.CommentEntity;
import lombok.Data;

@Data
public class CommentResponse {
	
	private Integer id;
	
	private List<CommentEntity> commentParentId;
	
	private Timestamp createAt;
	
	private String content;
	
	private int likeNumber;
	
	private String createBy;
	
}
