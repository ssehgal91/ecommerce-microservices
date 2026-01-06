package com.ecommerce.order.service.controller;

import com.ecommerce.order.service.model.Order;
import com.ecommerce.order.service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Checkout
    @PostMapping("/checkout")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order>  checkout(
            @RequestParam String userId,
            @RequestBody List<String> productIds
    ) {
        Order order = orderService.placeOrder(userId, productIds);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
