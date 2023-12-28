package com.example.review.controller;

import com.example.review.entity.CategoryEntity;
import com.example.review.exception.categoryExceptions.CategoryNameAlreadyExistException;
import com.example.review.exception.categoryExceptions.CategoryNotFoundException;
import com.example.review.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping("/create")
    public ResponseEntity createCategory(@RequestBody
                                             CategoryEntity categoryEntity){
        try {
            categoryService.createCategory(categoryEntity);
            return ResponseEntity.ok("Категорія створена");
        } catch (CategoryNameAlreadyExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping("/search")
    public ResponseEntity getCategoryByName(@RequestParam String name){
        try {
            return ResponseEntity.ok(categoryService.getCategoryByName(name));
        } catch (CategoryNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping("/search")
    public ResponseEntity getCategoryById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(categoryService.getCategoryById(id));
        } catch (CategoryNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }


    //TODO: Написати реалізацію CRUD для Category
}
