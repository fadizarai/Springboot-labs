package tn.tp.dev.microservice_customer;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroserviceCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCustomerApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CustomerRepository repo) {
		return args -> {
			repo.saveAll(List.of(
					new Customer(null, "Alice", "alice@mail.com"),
					new Customer(null, "Bob", "bob@mail.com")
			));
		};
	}
}