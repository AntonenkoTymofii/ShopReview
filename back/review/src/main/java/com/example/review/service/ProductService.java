package com.example.review.service;

import com.example.review.entity.CategoryEntity;
import com.example.review.entity.ProductEntity;
import com.example.review.exception.categoryExceptions.CategoryNameAlreadyExistException;
import com.example.review.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void createProduct(ProductEntity productEntity) {
        productRepo.save(productEntity);
    }
}
