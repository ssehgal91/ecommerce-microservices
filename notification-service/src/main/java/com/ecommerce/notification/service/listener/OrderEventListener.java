package com.ecommerce.notification.service.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @KafkaListener(topics = "order-topic", groupId = "notification-group")
    public void listen(String message) {
        System.out.println("🔔 Notification received: " + message);
    }
}
