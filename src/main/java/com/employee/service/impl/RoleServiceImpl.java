package com.employee.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.dto.RoleResponse;
import com.employee.dto.service.DtoService;
import com.employee.repository.RoleRepository;
import com.employee.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepository;
	private final DtoService dtoService;

	public RoleServiceImpl(RoleRepository roleRepository, DtoService dtoService) {
		super();
		this.roleRepository = roleRepository;
		this.dtoService = dtoService;
	}

	@Override
	public List<RoleResponse> getRoles() {

		return dtoService.roleResponse(roleRepository.findAll());
	}

}
