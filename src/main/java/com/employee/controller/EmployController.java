package com.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employee.dto.EmployRequest;
import com.employee.dto.EmployResponse;
import com.employee.service.EmployService;

@RestController
@RequestMapping("/employ")
public class EmployController {

	
	private final EmployService employService;
	
	
	
	
	public EmployController(EmployService employService) {
		super();
		this.employService = employService;
	}



	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "/saveEmploy", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<EmployResponse> saveEmploy(@RequestPart("employee") EmployRequest employRequest,
			@RequestPart("photo") MultipartFile photo, @RequestPart("resume") MultipartFile resume) throws Exception {
			
		EmployResponse response = employService.saveEmploy(employRequest, photo, resume);
		return new ResponseEntity<EmployResponse>(response,HttpStatus.CREATED);
	}
}
