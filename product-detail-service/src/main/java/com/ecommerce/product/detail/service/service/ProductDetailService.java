package com.ecommerce.product.detail.service.service;

import com.ecommerce.product.detail.service.exception.ProductDetailNotFoundException;
import com.ecommerce.product.detail.service.model.ProductDetail;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductDetailService {

    private final Map<String, ProductDetail> detailDB = new ConcurrentHashMap<>();

    public ProductDetailService() {
        // sample in-memory data
        detailDB.put("p1", new ProductDetail("p1", 1999.0, "M", "Modern"));
        detailDB.put("p2", new ProductDetail("p2", 2999.0, "L", "Classic"));
    }

    public ProductDetail getProductDetail(String productId) {
        ProductDetail detail = detailDB.get(productId);
        if (detail == null) {
            throw new ProductDetailNotFoundException(
                    "Product detail not found for productId: " + productId
            );
        }
        return detail;
    }
}
