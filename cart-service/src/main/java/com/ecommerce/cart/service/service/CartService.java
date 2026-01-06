package com.ecommerce.cart.service.service;

import com.ecommerce.cart.service.exception.CartNotFoundException;
import com.ecommerce.cart.service.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CartService {

    // userId -> cart items
    private final Map<String, List<CartItem>> cartDB = new ConcurrentHashMap<>();

    public void addToCart(String userId, CartItem item) {
        cartDB.computeIfAbsent(userId, k -> new ArrayList<>()).add(item);
    }

    public List<CartItem> getCart(String userId) {
        List<CartItem> items = cartDB.get(userId);
        if (items == null || items.isEmpty()) {
            throw new CartNotFoundException("Cart is empty for user: " + userId);
        }
        return items;
    }

    public void clearCart(String userId) {
        cartDB.remove(userId);
    }
}

