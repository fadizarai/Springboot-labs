package tn.tp.dev.order_service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import tn.tp.dev.order_service.model.Customer;

@SpringBootTest
@AutoConfigureStubRunner(
        ids = "tn.tp.dev:Customer-service:+:stubs:8085",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;

    @Test
    void shouldReturnStubbedResponse() {
        Customer c = customerClient.getCustomer("1").block();
        Assertions.assertEquals("Nom", c.name());
    }
}

