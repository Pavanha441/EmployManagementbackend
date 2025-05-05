package com.employee.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.dto.LoginResponse;
import com.employee.dto.RegisterRequest;
import com.employee.dto.service.DtoService;
import com.employee.entity.User;
import com.employee.exception.EmailAlreadyExistsException;
import com.employee.exception.UsernameAlreadyExistsException;
import com.employee.repository.RoleRepository;
import com.employee.repository.UserRepository;
import com.employee.service.UserInterface;

@Service
public class UserServiceImpl implements UserInterface {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	// private final PasswordEncoder passwordEncoder;
	private final DtoService dtoService;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, DtoService dtoService) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		// this.passwordEncoder = passwordEncoder;
		this.dtoService = dtoService;
	}

	@Override
	public void registerUser(RegisterRequest registerRequest) {
		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			throw new EmailAlreadyExistsException("Email already in use");
		}
		if (userRepository.existsByUsername(registerRequest.getUsername())) {
			throw new UsernameAlreadyExistsException("Username already in use");
		}

		userRepository.save(dtoService.registerUser(registerRequest));

	}

	@Override
	public LoginResponse getUser(String username, String email,String token) {
		Optional<User> user = userRepository.findByUsernameOrEmail(username, email);
		return dtoService.loggedUserDetails(user.get(), token);
		
	
	}

}
