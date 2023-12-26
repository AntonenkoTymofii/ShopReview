package com.example.review.model;

import com.example.review.entity.CategoryEntity;

public class Category {
    private Long id;
    private String name;

    public Category toModel(CategoryEntity categoryEntity){
        Category model = new Category();
        model.setId(categoryEntity.getId());
        model.setName(categoryEntity.getName());
        return model;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
