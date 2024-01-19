package com.example.review.controller;

import com.example.review.model.ProductModel;
import com.example.review.exception.productExceptions.ProductNotFoundException;
import com.example.review.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity createProduct(@RequestBody ProductModel productModel){
        try {
            productService.createProduct(productModel);
            return ResponseEntity.ok("Продукт було успішно створено");
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping
    public ResponseEntity getProductById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(productService.getProductById(id));
        } catch (ProductNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping("/name")
    public ResponseEntity getProductByName(@RequestParam String name){
        try {
            return ResponseEntity.ok(productService.getProductByName(name));
        } catch (ProductNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        try {
            return ResponseEntity.ok("Було успішно видалено продукт з id: " +
                    productService.deleteProduct(id));
        } catch (ProductNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @PutMapping("/edit")
    public ResponseEntity updateProduct(@RequestParam Long id,
                                         @RequestBody ProductModel productModel){
        try {
            productService.updateProduct(id, productModel);
            return ResponseEntity.ok("Дані продукту були оновлені успішно");
        }catch (ProductNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }
}
