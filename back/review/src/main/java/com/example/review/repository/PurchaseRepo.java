package com.example.review.repository;

import com.example.review.entity.PurchaseEntity;
import com.example.review.entity.ShopEntity;
import jakarta.persistence.Column;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PurchaseRepo extends CrudRepository<PurchaseEntity, Long> {
    List<PurchaseEntity> findByShopId(Long ShopId);
}
