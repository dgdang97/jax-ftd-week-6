package com.cooksys.model;

public class Response {
	private String response;
	private Long role;
	
	public Response() {
		super();
	}

	public Response(String response, Long role) {
		super();
		this.response = response;
		this.role = role;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}
}
