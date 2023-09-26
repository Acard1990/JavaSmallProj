package com.derp.scottSmallProj;

import com.derp.scottSmallProj.entity.AppUser;
import com.derp.scottSmallProj.repository.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.UUID;


@SpringBootApplication
@ComponentScan()
public class scottSmallProject {

	private static final Logger log = LoggerFactory.getLogger(scottSmallProject.class);

	public static void main(String[] args) {
		SpringApplication.run(scottSmallProject.class);
	}

	// You can use this for manually testing the application, however, just running cucumber test should be helpful
	@Bean
	public CommandLineRunner demo(AppUserRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new AppUser(UUID.fromString("8aa059f9-564b-436e-ae18-79ec06d868b9"), "John", "Doe", "John.Doe@test.com"));
			repository.save(new AppUser(UUID.fromString("8aa059f9-564b-436e-ae18-79ec06d868b8"), "Jane", "Doe", "Jane.Doe@test.com"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (AppUser appUser : repository.findAll()) {
				log.info(appUser.toString());
			}
			log.info("");
		};
	}
}
