package com.example.review.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "purchase")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    private Integer quantity;
    private Date date = Date.valueOf(LocalDate.now());

    @ManyToMany
    @JoinTable(
            name = "purchaseProduct",
            joinColumns = @JoinColumn(name = "id_purchase"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<ProductEntity> products;

    @ManyToOne
    @JoinColumn(name = "id_shop")
    private ShopEntity shop;

    public PurchaseEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }
}
