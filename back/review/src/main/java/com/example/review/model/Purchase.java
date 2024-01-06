package com.example.review.model;

import com.example.review.entity.ProductEntity;
import com.example.review.entity.PurchaseEntity;
import com.example.review.entity.ShopEntity;

import java.sql.Date;
import java.util.Set;

public class Purchase {
    private Long id;
    private Double price;
    private Integer quantity;
    private Date date;
    private Set<ProductEntity> products;
    private ShopEntity shop;

    public static Purchase toModel(PurchaseEntity purchaseEntity){
        Purchase model = new Purchase();
        model.setId(purchaseEntity.getId());
        model.setQuantity(purchaseEntity.getQuantity());
        model.setPrice(purchaseEntity.getPrice());
        model.setDate(purchaseEntity.getDate());
        model.setProducts(purchaseEntity.getProducts());
        model.setShop(purchaseEntity.getShop());
        return model;
    }

    public Purchase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }
}
