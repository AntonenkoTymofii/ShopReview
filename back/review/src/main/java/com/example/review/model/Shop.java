package com.example.review.model;

import com.example.review.entity.ShopEntity;

public class Shop {
    private Long id;
    private String name;
    private String address;
    private int quantity;

    public static Shop toModel(ShopEntity shopEntity){
        Shop model = new Shop();
        model.setId(shopEntity.getId());
        model.setName(shopEntity.getName());
        model.setAddress(shopEntity.getAddress());
        model.setQuantity(shopEntity.getQuantity());
        return model;
    }

    public Shop() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
