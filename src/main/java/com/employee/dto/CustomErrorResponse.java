package com.employee.dto;

import java.time.LocalDateTime;

public class CustomErrorResponse {

	private String message;
	private LocalDateTime time;
	private int status;

	public CustomErrorResponse(String message, int status) {
		super();
		this.message = message;
		this.time = LocalDateTime.now();;
		this.status = status;
	}

}
