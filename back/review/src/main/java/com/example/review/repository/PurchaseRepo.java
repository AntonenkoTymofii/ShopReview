package com.example.review.repository;

import com.example.review.entity.PurchaseEntity;
import com.example.review.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseRepo extends CrudRepository<PurchaseRepo, Long> {
    List<PurchaseEntity> findByIdShop(Long id_shop);
}
