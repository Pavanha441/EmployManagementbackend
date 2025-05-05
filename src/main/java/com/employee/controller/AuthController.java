package com.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.configuration.JwtUtil;
import com.employee.dto.LoginRequest;
import com.employee.dto.LoginResponse;
import com.employee.dto.RegisterRequest;
import com.employee.dto.RoleResponse;
import com.employee.exception.InvalidCrediantailsException;
import com.employee.service.RoleService;
import com.employee.service.UserInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

	private final UserInterface userInterface;
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private final RoleService roleService;

	public AuthController(UserInterface userInterface, JwtUtil jwtUtil, AuthenticationManager authenticationManager,
			RoleService roleService) {
		super();
		this.userInterface = userInterface;
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
		this.roleService = roleService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
		System.out.println(" User adding " + registerRequest.getUsername());
		userInterface.registerUser(registerRequest);
		return ResponseEntity.ok(Map.of("message", "User registered successfully"));
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest)
			throws InvalidCrediantailsException {
		try {
			System.out.println(" login" + loginRequest.getUserNameEmail() + "  " + loginRequest.getPassword());
			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					loginRequest.getUserNameEmail(), loginRequest.getPassword()));
			UserDetails details = (UserDetails) authenticate.getPrincipal();
			String token = jwtUtil.generateToken(details);
			
			LoginResponse loginResponse = userInterface.getUser(loginRequest.getUserNameEmail(), loginRequest.getUserNameEmail(), token);
			return ResponseEntity.ok(loginResponse);

		} catch (Exception e) {
			System.out.println(e);
			throw new InvalidCrediantailsException("Invalid username or password");
		}

	}

	@GetMapping("/roles")
	public ResponseEntity<List<RoleResponse>> getRoles() {

		return ResponseEntity.ok(roleService.getRoles());

	}

}
