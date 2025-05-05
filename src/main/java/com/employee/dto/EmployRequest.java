package com.employee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmployRequest {

	@NotBlank(message = "First name is blank")
	private String firstName;

	private String middleName;

	@NotBlank(message = "Laatname cant be blank ")
	private String lastName;

	@NotBlank(message = "Email cant be blank")
	@Email(message = "Email is not valid  ")
	private String email;

	@NotBlank(message = "Phone no cant be blank")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
	private String phone;
	
	@NotBlank(message = "Department is lank")
	private String department;
	
	private Double salary;
		
	private String designation;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

}
