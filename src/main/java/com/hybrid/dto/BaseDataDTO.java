package com.hybrid.dto;

public class BaseDataDTO<T> extends BaseDTO{
	private T data;
	
		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}	
}
