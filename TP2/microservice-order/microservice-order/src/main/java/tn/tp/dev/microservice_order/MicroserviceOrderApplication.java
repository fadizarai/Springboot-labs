package tn.tp.dev.microservice_order;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroserviceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOrderApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	CommandLineRunner initDatabase(OrderRepository repo) {
		return args -> {
			repo.saveAll(List.of(
					new Order(null, "Laptop", 1, 1L),
					new Order(null, "Smartphone", 2, 2L),
					new Order(null, "Headphones", 1, 3L)
			));
		};
	}
}