package com.imagesave.imagesave;

import com.imagesave.imagesave.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImagesaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImagesaveApplication.class, args);
	}

	@Bean
	public CommandLineRunner createAdminUser(UserService userService) {
		return args -> {
			userService.createMainUser();
		};
	}

}
