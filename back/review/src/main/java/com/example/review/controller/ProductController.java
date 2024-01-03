package com.example.review.controller;

import com.example.review.entity.ProductEntity;
import com.example.review.exception.shopException.ShopNameAlreadyExistException;
import com.example.review.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity createProduct(@RequestBody ProductEntity productEntity){
        try {
            productService.createProduct(productEntity);
            return ResponseEntity.ok("Продукт було успішно створено");
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping
    public ResponseEntity getProductById(Long id){
        try {
            return ResponseEntity.ok("Сервер працює");
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }
}
