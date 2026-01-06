package com.ecommerce.product.detail.service.controller;

import com.ecommerce.product.detail.service.model.ProductDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-details")
public class ProductDetailController {


    @GetMapping("/{id}")
    public ProductDetail get(@PathVariable String id) {
        return new ProductDetail(id, 1000.0, "M", "Modern");
    }
}
