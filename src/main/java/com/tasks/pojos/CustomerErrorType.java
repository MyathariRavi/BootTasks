package com.tasks.pojos;

public class CustomerErrorType extends AuthResponse {
	 private String error;
	 

	public CustomerErrorType(String error) {
		super();
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	 
	
	

}
