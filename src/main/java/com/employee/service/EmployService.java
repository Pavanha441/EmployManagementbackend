package com.employee.service;

import org.springframework.web.multipart.MultipartFile;

import com.employee.dto.EmployRequest;
import com.employee.dto.EmployResponse;


public interface EmployService {

	EmployResponse saveEmploy(EmployRequest request, MultipartFile photo, MultipartFile resume) throws Exception;
}
