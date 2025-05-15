package com.employee.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employee.configuration.EmployUtils;
import com.employee.dto.EmployRequest;
import com.employee.dto.EmployResponse;
import com.employee.dto.service.DtoService;
import com.employee.entity.Employee;
import com.employee.entity.User;
import com.employee.exception.EmailAlreadyExistsException;
import com.employee.repository.EmployRepository;
import com.employee.repository.UserRepository;
import com.employee.service.EmployService;
import com.employee.service.FileStorageService;

@Service
public class EmployServiceImpl implements EmployService {

	private final EmployRepository employRepository;
	private final DtoService dtoService;
	private final FileStorageService fileStorageService;
	private final UserRepository userRepository;

	public EmployServiceImpl(EmployRepository employRepository, DtoService dtoService,
			FileStorageService fileStorageService, UserRepository userRepository) {
		super();
		this.employRepository = employRepository;
		this.dtoService = dtoService;
		this.fileStorageService = fileStorageService;
		this.userRepository = userRepository;
	}

	@Override
	public EmployResponse saveEmploy(EmployRequest request, MultipartFile photo, MultipartFile resume)
			throws Exception {

		
		Employee employee = dtoService.saveUser(request);
		User user = dtoService.registerEmployToUser(request);
		if (employRepository.existsByEmail(employee.getEmail())) {
			throw new EmailAlreadyExistsException("Email already in use ,Please add other email");
		}
		String photName = fileStorageService.saveFile(photo, EmployUtils.photoPath);
		String docName = fileStorageService.saveFile(resume, EmployUtils.docsPath);

		employee.setPhotoName(photName);
		employee.setResumeName(docName);

		User saveUser = userRepository.save(user);
		
		employee.setUser(saveUser);
		
		Employee saveEmployee = employRepository.save(employee);

		return dtoService.getEmployRespone(saveEmployee);

	}

}
