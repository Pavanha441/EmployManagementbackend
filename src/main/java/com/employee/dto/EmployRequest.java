package com.employee.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmployRequest {

	@NotBlank(message = "First name is blank")
	@JsonProperty("firstName")
	private String firstName;

	@JsonIgnore
	private String middleName;

	@NotBlank(message = "Laatname cant be blank ")
	@JsonProperty("lastName")
	private String lastName;

	@NotBlank(message = "Email cant be blank")
	@Email(message = "Email is not valid  ")
	@JsonProperty("email")
	private String email;

	@NotBlank(message = "Phone no cant be blank")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
	@JsonProperty("phone")
	private String phone;

	@NotBlank(message = "Department is lank")
	private String department;

	@JsonProperty("salary")
	private Double salary;

	@JsonProperty("designation")
	private String designation;

	@JsonProperty("username")
	private String username;

	@JsonProperty("roles")
	private Set<String> roles;

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

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "EmployRequest [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", department=" + department + ", salary=" + salary
				+ ", designation=" + designation + ", username=" + username + ", roles=" + roles + "]";
	}

}
