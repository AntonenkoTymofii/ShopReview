package com.example.review.repository;

import com.example.review.entity.PurchaseEntity;
import com.example.review.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;


import java.sql.Date;
import java.util.List;

public interface PurchaseRepo extends CrudRepository<PurchaseEntity, Long> {
    List<PurchaseEntity> findByShop(ShopEntity shop);
    List<PurchaseEntity> findByDate(Date date);
}
