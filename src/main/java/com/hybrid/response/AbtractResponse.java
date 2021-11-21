package com.hybrid.response;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AbtractResponse {
	
	private int id;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;

}
