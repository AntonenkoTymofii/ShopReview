package com.example.review.repository;

import com.example.review.model.PurchaseModel;
import com.example.review.model.ShopModel;
import org.springframework.data.repository.CrudRepository;


import java.sql.Date;
import java.util.List;

public interface PurchaseRepo extends CrudRepository<PurchaseModel, Long> {
    List<PurchaseModel> findByShop(ShopModel shop);
    List<PurchaseModel> findByDate(Date date);
}
