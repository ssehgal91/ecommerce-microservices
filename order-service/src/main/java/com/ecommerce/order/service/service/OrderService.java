package com.ecommerce.order.service.service;

import com.ecommerce.order.service.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "order-topic";

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public OrderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Order placeOrder(String userId, List<String> productIds) {
        Order order = new Order(
                UUID.randomUUID().toString(),
                userId,
                productIds
        );

        // publish event
        try {
            kafkaTemplate.send(TOPIC, "ORDER_CREATED for user " + userId);
            log.info("Order event published to Kafka for user {}", userId);
        } catch (Exception e) {
            log.error("Kafka publish failed. Continuing order flow.", e);
        }

        return order;
    }
}
