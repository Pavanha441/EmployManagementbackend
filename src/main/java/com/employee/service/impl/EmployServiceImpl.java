package com.employee.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employee.configuration.EmployUtils;
import com.employee.dto.EmployRequest;
import com.employee.dto.EmployResponse;
import com.employee.dto.service.DtoService;
import com.employee.entity.Employee;
import com.employee.exception.EmailAlreadyExistsException;
import com.employee.repository.EmployRepository;
import com.employee.service.EmployService;
import com.employee.service.FileStorageService;

@Service
public class EmployServiceImpl implements EmployService {

	private final EmployRepository employRepository;
	private final DtoService dtoService;
	private final FileStorageService fileStorageService;

	public EmployServiceImpl(EmployRepository employRepository, DtoService dtoService,
			FileStorageService fileStorageService) {
		super();
		this.employRepository = employRepository;
		this.dtoService = dtoService;
		this.fileStorageService = fileStorageService;
	}

	@Override
	public EmployResponse saveEmploy(EmployRequest request, MultipartFile photo, MultipartFile resume) throws Exception {

		String photName = fileStorageService.saveFile(photo, EmployUtils.photoPath);
		String docName = fileStorageService.saveFile(resume, EmployUtils.docsPath);

		Employee employee = dtoService.saveUser(request);
		employee.setPhotoName(photName);
		employee.setResumeName(docName);

		if (employRepository.existsByEmail(employee.getEmail())) {
			throw new EmailAlreadyExistsException("Email already in use ,Please add other email");
		}

	
		
		Employee saveEmployee = employRepository.save(employee);
		
		return  dtoService.getEmployRespone(saveEmployee);

	}

}
