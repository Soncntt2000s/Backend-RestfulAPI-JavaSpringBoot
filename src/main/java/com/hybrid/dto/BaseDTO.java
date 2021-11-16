package com.hybrid.dto;

public class BaseDTO {
	private int reponseCode;
	
	private String message;

	public void setreponse_code(int reponseCode) {
		this.reponseCode = reponseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
	public int getreponse_code() {
		return reponseCode;
	}
}
