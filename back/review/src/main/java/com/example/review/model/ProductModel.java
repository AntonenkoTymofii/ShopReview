package com.example.review.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Float price;

    @ManyToMany(mappedBy = "products")
    private Set<PurchaseModel> purchases;

    @ManyToMany(mappedBy = "products")
    private Set<CategoryModel> categories;

    @ManyToMany(mappedBy = "products")
    private Set<ShopModel> shops;

    public static ProductModel toModel(ProductModel productModel){
        ProductModel model = new ProductModel();
        model.setId(productModel.getId());
        model.setName(productModel.getName());
        model.setPrice(productModel.getPrice());
        return model;
    }

    public ProductModel() {
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Set<PurchaseModel> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<PurchaseModel> purchases) {
        this.purchases = purchases;
    }

    public Set<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryModel> categories) {
        this.categories = categories;
    }

    public Set<ShopModel> getShops() {
        return shops;
    }

    public void setShops(Set<ShopModel> shops) {
        this.shops = shops;
    }
}
