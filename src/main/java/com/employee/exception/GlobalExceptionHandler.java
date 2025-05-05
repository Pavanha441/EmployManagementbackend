package com.employee.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<?> emailAlreadtExits(EmailAlreadyExistsException ex) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(UsernameAlreadyExistsException.class)
	public ResponseEntity<?> userNameAlreadtExits(EmailAlreadyExistsException ex) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(InvalidCrediantailsException.class)
	public ResponseEntity<?> handleUserCredintails(InvalidCrediantailsException ex) {
		System.out.println(ex);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(IOException.class)
	public ResponseEntity<?> handleIoException(IOException ie) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", ie.getMessage()));

	}

}
