package tn.tp.dev.order_service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tn.tp.dev.order_service.model.Customer;

@Service
public class CustomerClient {

    private final WebClient webClient =
            WebClient.create("http://localhost:8085");

    public Mono<Customer> getCustomer(String id) {
        return webClient.get()
                .uri("/customers/{id}", id)
                .retrieve()
                .bodyToMono(Customer.class);
    }
}

