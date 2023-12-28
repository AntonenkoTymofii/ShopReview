package com.example.review.controller;

import com.example.review.entity.UserEntity;
import com.example.review.exception.userExceptions.UserEmailAlreadyExistException;
import com.example.review.exception.userExceptions.UserNotFoundException;
import com.example.review.exception.userExceptions.UserPhoneAlreadyExistException;
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
            userService.registrationUser(userEntity);
            return ResponseEntity.ok("Користувач зареєстрований");
        } catch (UserEmailAlreadyExistException | UserPhoneAlreadyExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping("/search")
    public ResponseEntity getUserByID(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getByID(id));
        } catch (UserNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping("/email")
    public ResponseEntity getUserByEmail(@RequestParam String email){
        try {
            return ResponseEntity.ok(userService.getByEmail(email));
        } catch (UserNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok("Було успішно видалено користувача з id: " +
                    userService.deleteUser(id));
        } catch (UserNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestParam Long id,
                                     @RequestBody UserEntity user){
        try {
            userService.updateUser(id, user);
            return ResponseEntity.ok("Дані користувача були оновлені успішно");
        }catch (UserNotFoundException | UserEmailAlreadyExistException |
                UserPhoneAlreadyExistException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }
}
