package com.employee.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank(message = "Please enter username or email")
	private String userNameEmail;
	
	@NotBlank(message = "Please enter password")
	private String password;

	public String getUserNameEmail() {
		return userNameEmail;
	}

	public void setUserNameEmail(String userNameEmail) {
		this.userNameEmail = userNameEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	 

}
