package com.example.authbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AuthbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthbackendApplication.class, args);
	}

}
