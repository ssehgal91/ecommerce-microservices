package com.ecommerce.product.service.service;

import com.ecommerce.product.service.exception.ProductNotFoundException;
import com.ecommerce.product.service.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductService {

    private final Map<String, Product> productDB = new ConcurrentHashMap<>();

    public Product addProduct(Product product) {
        productDB.put(product.getId(), product);
        return product;
    }

    public Collection<Product> getAllProducts() {
        return productDB.values();
    }

    public void deleteProduct(String id) {
        if (!productDB.containsKey(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        productDB.remove(id);
    }
}
