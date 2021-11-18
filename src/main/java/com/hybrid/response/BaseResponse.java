package com.hybrid.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse {
	
	private int responseCode;
	
	private String message;public BaseResponse() {
		// TODO Auto-generated constructor stub
	}
	
	@JsonProperty("response_code")
	public int getReponseCode() {
		return responseCode;
	}

	public void setReponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
