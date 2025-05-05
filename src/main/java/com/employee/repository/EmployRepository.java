package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Employee;

public interface EmployRepository  extends JpaRepository<Employee, Long> {

	
	boolean existsByEmail(String email);
}
