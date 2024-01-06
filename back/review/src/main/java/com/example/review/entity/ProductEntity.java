package com.example.review.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Float price;

    @ManyToMany(mappedBy = "products")
    private Set<PurchaseEntity> purchases;

    @ManyToMany(mappedBy = "products")
    private Set<CategoryEntity> categories;

    @ManyToMany(mappedBy = "products")
    private Set<ShopEntity> shops;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public Set<PurchaseEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<PurchaseEntity> purchases) {
        this.purchases = purchases;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }

    public Set<ShopEntity> getShops() {
        return shops;
    }

    public void setShops(Set<ShopEntity> shops) {
        this.shops = shops;
    }
}
