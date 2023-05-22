package com.task.security;

import com.task.security.request.RegisterRequest;
import com.task.security.service.AuthenticationService;

import static com.task.security.entity.Role.ADMIN;
import static com.task.security.entity.Role.USER;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Apel")
					.lastname("Sorker")
					.username("apelsorker")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var user = RegisterRequest.builder()
					.firstname("Tanvir")
					.lastname("Prince")
					.username("tanvirprince")
					.email("user@mail.com")
					.password("password")
					.role(USER)
					.build();
			System.out.println("User token: " + service.register(user).getAccessToken());

		};
	}
}
