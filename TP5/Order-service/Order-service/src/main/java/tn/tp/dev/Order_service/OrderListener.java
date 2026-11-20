package tn.tp.dev.Order_service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receiveOrder(OrderDto order) {
        System.out.println("Commande reçue : " + order.getProductName() +
                " pour le client " + order.getCustomerId());
    }
}