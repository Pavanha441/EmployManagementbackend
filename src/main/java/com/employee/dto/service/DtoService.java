package com.employee.dto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.employee.configuration.EmployUtils;
import com.employee.dto.EmployRequest;
import com.employee.dto.EmployResponse;
import com.employee.dto.LoginResponse;
import com.employee.dto.RegisterRequest;
import com.employee.dto.RoleResponse;
import com.employee.entity.Employee;
import com.employee.entity.Role;
import com.employee.entity.User;
import com.employee.repository.RoleRepository;

@Service
public class DtoService {

	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;

	public DtoService(PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
		// super();
		this.passwordEncoder = passwordEncoder;
		this.roleRepository = roleRepository;
	}

	public User registerUser(RegisterRequest registerRequest) {

		User user = new User();
		user.setUsername(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

		Set<Role> roles = new HashSet<>();

		if (CollectionUtils.isEmpty(registerRequest.getRoles())) {
			Role role = roleRepository.findByName(EmployUtils.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Default role not found"));
			roles.add(role);
		} else {
			for (String role : registerRequest.getRoles()) {
				Role userRole = roleRepository.findByName(role)
						.orElseThrow(() -> new RuntimeException("Role not found :" + role));
				roles.add(userRole);
			}
		}

		user.setRoles(roles);

		return user;
	}

	public Employee saveUser(EmployRequest employRequest) {

		Employee employee = new Employee();
		employee.setFirstName(employRequest.getFirstName());
		employee.setMiddleName(employRequest.getMiddleName());
		employee.setLastName(employRequest.getLastName());
		employee.setDepartment(employRequest.getDepartment());
		employee.setDesignation(employRequest.getDepartment());
		employee.setSalary(employRequest.getSalary());
		employee.setEmail(employRequest.getEmail());
		employee.setCreateBy(getCurrentUsername());

		return employee;
	}

	public String getCurrentUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication != null ? authentication.getName() : "SYSTEM";
	}

	public EmployResponse getEmployRespone(Employee employee) {

		return new EmployResponse(employee.getFirstName() + " " + employee.getLastName(), employee.getEmail());

//		return employResponse;
	}

	public List<RoleResponse> roleResponse(List<Role> roles) {

		List<RoleResponse> roleResponses = new ArrayList<>();

		for (Role role : roles) {
			switch (role.getName()) {
			case EmployUtils.ROLE_ADMIN:
				roleResponses.add(new RoleResponse(role.getId(), "Admin", EmployUtils.ROLE_ADMIN));

				break;
			case EmployUtils.ROLE_EMPLOY:
				roleResponses.add(new RoleResponse(role.getId(), "Employ", EmployUtils.ROLE_EMPLOY));

				break;
			case EmployUtils.ROLE_FM:
				roleResponses.add(new RoleResponse(role.getId(), "Finance Manager", EmployUtils.ROLE_FM));

				break;
			case EmployUtils.ROLE_HR:
				roleResponses.add(new RoleResponse(role.getId(), "HR", EmployUtils.ROLE_HR));

				break;

			case EmployUtils.ROLE_PROJECT_MANAGER:
				roleResponses.add(new RoleResponse(role.getId(), "Project Manager", EmployUtils.ROLE_PROJECT_MANAGER));

				break;
			case EmployUtils.ROLE_USER:
				roleResponses.add(new RoleResponse(role.getId(), "User", EmployUtils.ROLE_USER));

				break;

			default:
				break;
			}
		}

		return roleResponses;
	}
	
	public LoginResponse  loggedUserDetails(User details,String token) {
		
		LoginResponse loginResponse = new LoginResponse();
		
		loginResponse.setToken(token);
		loginResponse.setUsername(details.getUsername());
		loginResponse.setEmail(details.getEmail());
		loginResponse.setRoles(details.getRoles());
		
		return loginResponse;
	}

}
