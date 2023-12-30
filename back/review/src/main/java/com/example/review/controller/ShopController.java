package com.example.review.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @GetMapping
    public ResponseEntity getShop(){
        try {
            return ResponseEntity.ok("Сервіс працює");
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }
}
