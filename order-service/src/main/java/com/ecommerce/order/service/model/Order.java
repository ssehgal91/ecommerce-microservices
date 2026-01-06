package com.ecommerce.order.service.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String orderId;
    private String userId;
    private List<String> productIds;
    private LocalDateTime createdAt;

    public Order() {}

    public Order(String orderId, String userId, List<String> productIds) {
        this.orderId = orderId;
        this.userId = userId;
        this.productIds = productIds;
        this.createdAt = LocalDateTime.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
