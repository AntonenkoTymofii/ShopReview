package com.example.review.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "shop")
public class ShopModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    private int quantity;
    private String country;
    private String city;
    private String street;
    private String house;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
    private ArrayList<PurchaseModel> purchases;

    @ManyToMany
    @JoinTable(
            name = "productShop",
            joinColumns = @JoinColumn(name = "id_shop"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<ProductModel> products;

    public static ShopModel toModel(ShopModel shopModel){
        ShopModel model = new ShopModel();
        model.setId(shopModel.getId());
        model.setName(shopModel.getName());
        model.setCountry(shopModel.getCountry());
        model.setCity(shopModel.getCity());
        model.setStreet(shopModel.getStreet());
        model.setHouse(shopModel.getHouse());
        model.setQuantity(shopModel.getQuantity());
        return model;
    }

    public ShopModel() {
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<PurchaseModel> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<PurchaseModel> purchases) {
        this.purchases = purchases;
    }

    public Set<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductModel> products) {
        this.products = products;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
