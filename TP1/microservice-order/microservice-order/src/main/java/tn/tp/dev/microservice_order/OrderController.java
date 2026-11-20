package tn.tp.dev.microservice_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/with-products")
    public String getOrdersWithProducts() {
        String products = restTemplate.getForObject("http://localhost:8080/products", String.class);
        return "Commandes avec produits : " + products;
    }
}