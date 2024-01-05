package com.example.review.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "purchase")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    private Integer quantity;
    private Date date = Date.valueOf(LocalDate.now());

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase")
//    @JoinColumn(name = "id_product")
//    private List<ProductEntity> products;
//    @ManyToMany

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
}
