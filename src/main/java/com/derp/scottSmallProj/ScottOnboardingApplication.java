package com.derp.scottSmallProj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan()
public class ScottOnboardingApplication {

	private static final Logger log = LoggerFactory.getLogger(ScottOnboardingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScottOnboardingApplication.class);
	}

	// You can use this for manually testing the application, however, just running cucumber test should be helpful
//	@Bean
//	public CommandLineRunner demo(AppUserRepository repository) {
//		return (args) -> {
//			// save a few customers
//			repository.save(new AppUser(UUID.fromString("8aa059f9-564b-436e-ae18-79ec06d868b9"), "User", "One", "User.One@bc.com"));
//			repository.save(new AppUser(UUID.fromString("8aa059f9-564b-436e-ae18-79ec06d868b8"), "User", "Two", "User.Two@bc.com"));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (AppUser appUser : repository.findAll()) {
//				log.info(appUser.toString());
//			}
//			log.info("");
//		};
//	}
}
