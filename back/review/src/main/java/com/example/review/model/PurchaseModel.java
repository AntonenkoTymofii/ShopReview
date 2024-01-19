package com.example.review.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "purchase")
public class PurchaseModel {

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
    private Set<ProductModel> products;

    @ManyToOne
    @JoinColumn(name = "id_shop")
    private ShopModel shop;


    public static PurchaseModel toModel(PurchaseModel purchaseModel){
        PurchaseModel model = new PurchaseModel();
        model.setId(purchaseModel.getId());
        model.setQuantity(purchaseModel.getQuantity());
        model.setPrice(purchaseModel.getPrice());
        model.setDate(purchaseModel.getDate());
        model.setProducts(purchaseModel.getProducts());
        model.setShop(purchaseModel.getShop());
        return model;
    }

    public PurchaseModel() {
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

    public ShopModel getShop() {
        return shop;
    }

    public void setShop(ShopModel shop) {
        this.shop = shop;
    }

    public Set<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductModel> products) {
        this.products = products;
    }
}
