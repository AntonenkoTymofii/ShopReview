package com.example.review.repository;

import com.example.review.model.ProductModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<ProductModel, Long> {
    List<ProductModel> findByName(String name);
    List<ProductModel> findByPurchasesId(Long PurchasesId);
}
