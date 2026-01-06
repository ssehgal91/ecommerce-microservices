package com.ecommerce.product.detail.service.model;

public class ProductDetail {

    private String productId;
    private Double price;
    private String size;
    private String design;

    public ProductDetail() {
    }

    public ProductDetail(String productId, Double price, String size, String design) {
        this.productId = productId;
        this.price = price;
        this.size = size;
        this.design = design;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }
}
