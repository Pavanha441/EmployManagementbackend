package com.employee.service;

import com.employee.dto.LoginResponse;
import com.employee.dto.RegisterRequest;

public interface UserInterface {

	
	void registerUser(RegisterRequest registerRequest);
	
	LoginResponse getUser(String username,String email,String token);
}
