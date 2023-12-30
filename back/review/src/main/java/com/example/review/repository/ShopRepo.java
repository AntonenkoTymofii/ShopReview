package com.example.review.repository;

import com.example.review.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepo extends CrudRepository<ShopEntity, Long> {
    ShopEntity findByName(String name);
}
