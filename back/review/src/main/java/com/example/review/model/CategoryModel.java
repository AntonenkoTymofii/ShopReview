package com.example.review.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "productCategory",
            joinColumns = @JoinColumn(name = "id_category"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<ProductModel> products;

    private String name;

    public static CategoryModel toModel(CategoryModel categoryModel){
        CategoryModel model = new CategoryModel();
        model.setId(categoryModel.getId());
        model.setName(categoryModel.getName());
        return model;
    }

    public CategoryModel(){}

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

    public Set<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductModel> products) {
        this.products = products;
    }
}
