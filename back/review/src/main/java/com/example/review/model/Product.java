package com.example.review.model;

import com.example.review.entity.ProductEntity;

public class Product {
    private Long id;
    private String name;
    private Float price;

    public static Product toModel(ProductEntity productEntity){
        Product model = new Product();
        model.setId(productEntity.getId());
        model.setName(productEntity.getName());
        model.setPrice(productEntity.getPrice());
        return model;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
