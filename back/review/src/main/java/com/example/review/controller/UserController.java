package com.example.review.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity getUser(){
        try {
            return ResponseEntity.ok("Сервер працює");
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }
}
