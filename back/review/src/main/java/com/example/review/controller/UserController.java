package com.example.review.controller;

import com.example.review.entity.UserEntity;
import com.example.review.exception.EmailAlreadyExistException;
import com.example.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity userEntity){
        try {
            userService.registrateUser(userEntity);
            return ResponseEntity.ok("Користувач зареєстрований");
        } catch (EmailAlreadyExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping("/user")
    public ResponseEntity getUserByID(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getByID(id));
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping("/email")
    public ResponseEntity getUserByEmail(@RequestParam String email){
        try {
            return ResponseEntity.ok("Сервер працює");
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }
}
