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

    @ManyToMany
    private Set<PurchaseEntity> purchases;

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
}
