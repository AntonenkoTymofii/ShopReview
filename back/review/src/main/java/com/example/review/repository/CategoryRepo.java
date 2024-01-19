package com.example.review.repository;

import com.example.review.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<CategoryModel, Long> {
    CategoryModel findByName(String name);
}
