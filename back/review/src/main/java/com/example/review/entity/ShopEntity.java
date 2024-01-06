package com.example.review.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "shop")
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    private String address;
    private int quantity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
    private ArrayList<PurchaseEntity> purchases;

    @ManyToMany
    @JoinTable(
            name = "productShop",
            joinColumns = @JoinColumn(name = "id_shop"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<ProductEntity> products;


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

    public ArrayList<PurchaseEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<PurchaseEntity> purchases) {
        this.purchases = purchases;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }
}
