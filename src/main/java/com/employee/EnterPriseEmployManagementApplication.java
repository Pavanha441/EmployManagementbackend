package com.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.employee.entity.Role;
import com.employee.repository.RoleRepository;

@SpringBootApplication
public class EnterPriseEmployManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterPriseEmployManagementApplication.class, args);
		System.out.println(" Welcome to EMploy Management");
	}

	@Bean
	CommandLineRunner run(RoleRepository repository) {
		return  args->{
			
			
		};
		
	}
	
}
