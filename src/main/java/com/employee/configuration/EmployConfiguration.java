package com.employee.configuration;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.employee.entity.Role;
import com.employee.entity.User;
import com.employee.repository.RoleRepository;
import com.employee.repository.UserRepository;

@Configuration
public class EmployConfiguration {

	// private final AuthenticationConfiguration authConfig;

	@Bean
	CommandLineRunner runner(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			if (roleRepository.count() == 0) {
//				roleRepository.save(new Role(null, EmployUtils.ROLE_ADMIN));
//				roleRepository.save(new Role(null, EmployUtils.ROLE_USER));
//				roleRepository.save(new Role(null,EmployUtils.ROLE_EMPLOY));
//				roleRepository.save(new Role(null,EmployUtils.ROLE_FM));
//				roleRepository.save(new Role(null,EmployUtils.ROLE_PROJECT_MANAGER));
//				roleRepository.save(new Role(null,EmployUtils.ROLE_HR));
//				
				roleRepository
						.saveAll(List.of(new Role(null, EmployUtils.ROLE_ADMIN), new Role(null, EmployUtils.ROLE_USER),
								new Role(null, EmployUtils.ROLE_EMPLOY), new Role(null, EmployUtils.ROLE_FM),
								new Role(null, EmployUtils.ROLE_PROJECT_MANAGER), new Role(null, EmployUtils.ROLE_HR)));

			}

			if (!userRepository.existsByUsername("admin")) {

				Role adminRole = roleRepository.findByName(EmployUtils.ROLE_ADMIN).orElseThrow();
				User user = new User();
				user.setUsername("admin");
				user.setEmail("pavanha441@gmail.com");
				user.setPassword(encoder.encode("admin123"));
				user.setRoles(Set.of(adminRole));
				user.setActive(true);

				user = userRepository.save(user);
				System.out.println(" Details " + user.getUsername() + "  " + user.getRoles());

			}
		};
	}

	@Bean
	public AuthenticationManager getAuthManage(AuthenticationConfiguration config) throws Exception {
		System.out.println(" AuthenticationConfiguration  bean created");
		return config.getAuthenticationManager();
	}
}
