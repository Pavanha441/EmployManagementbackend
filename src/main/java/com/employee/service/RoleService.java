package com.employee.service;

import java.util.List;

import com.employee.dto.RoleResponse;
import com.employee.entity.Role;

public interface RoleService {
	
	public List<RoleResponse> getRoles();

}
