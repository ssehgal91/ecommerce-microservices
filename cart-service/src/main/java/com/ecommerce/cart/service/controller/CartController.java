package com.ecommerce.cart.service.controller;

import com.ecommerce.cart.service.model.CartItem;
import com.ecommerce.cart.service.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Add item to cart
    @PostMapping("/{userId}/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addToCart(
            @PathVariable String userId,
            @RequestBody CartItem item
    ) {
        cartService.addToCart(userId, item);
    }

    // View cart
    @GetMapping("/{userId}")
    public List<CartItem> viewCart(@PathVariable String userId) {
        return cartService.getCart(userId);
    }

    // Clear cart (optional)
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
    }
}
