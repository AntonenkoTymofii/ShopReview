package com.example.review.repository;

import com.example.review.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface PurchaseRepo extends CrudRepository<PurchaseEntity, Long> {
    List<PurchaseEntity> findByShopId(Long ShopId);
}
