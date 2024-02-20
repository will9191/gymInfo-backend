package com.example.gymInfo;

import com.example.gymInfo.auth.AuthenticationRequest;
import com.example.gymInfo.auth.AuthenticationService;
import com.example.gymInfo.auth.RegisterRequest;
import com.example.gymInfo.exercise.ExerciseRequest;
import com.example.gymInfo.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

import static com.example.gymInfo.user.Role.ADMIN;
import static com.example.gymInfo.user.Role.MANAGER;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class GymInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymInfoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstName("Willian")
					.lastName("Pereira")
					.email("admin@gmail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());


			var manager = RegisterRequest.builder()
					.firstName("Admin")
					.lastName("Admin")
					.email("manager@gmail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());
		};
	}

}
