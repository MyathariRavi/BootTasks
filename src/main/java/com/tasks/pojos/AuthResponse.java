package com.tasks.pojos;

public class AuthResponse {
	
	private String jwt;
	
	public AuthResponse() {}

	public AuthResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
	

}
