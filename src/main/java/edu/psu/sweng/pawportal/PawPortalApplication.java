package edu.psu.sweng.pawportal;

import edu.psu.sweng.pawportal.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
public class PawPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawPortalApplication.class, args);
	}

}
