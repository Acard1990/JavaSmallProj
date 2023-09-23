package com.stormwind.scottOnboarding;

import com.stormwind.scottOnboarding.entity.AppUser;
import com.stormwind.scottOnboarding.repository.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan()
public class ScottOnboardingApplication {

	private static final Logger log = LoggerFactory.getLogger(ScottOnboardingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScottOnboardingApplication.class);
	}

//	@Bean
//	public CommandLineRunner demo(AppUserRepository repository) {
//		return (args) -> {
//			// save a few customers
//			repository.save(new AppUser("User", "One", "User.One@bc.com"));
//			repository.save(new AppUser("User", "Two", "User.Two@bc.com"));
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
