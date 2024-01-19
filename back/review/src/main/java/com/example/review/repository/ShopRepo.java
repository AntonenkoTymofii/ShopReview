package com.example.review.repository;

import com.example.review.model.ShopModel;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepo extends CrudRepository<ShopModel, Long> {
    ShopModel findByName(String name);
}
