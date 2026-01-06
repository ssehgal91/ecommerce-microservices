package com.ecommerce.product.detail.service.exception;

public class ProductDetailNotFoundException extends RuntimeException {

    public ProductDetailNotFoundException(String message) {
        super(message);
    }
}
