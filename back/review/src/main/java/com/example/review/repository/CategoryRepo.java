package com.example.review.repository;

import com.example.review.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<CategoryEntity, Long> {
    CategoryEntity findByName(String name);
}
