package com.example.review.controller;

import com.example.review.entity.ShopEntity;
import com.example.review.exception.shopException.ShopNameAlreadyExistException;
import com.example.review.exception.shopException.ShopNotFoundException;
import com.example.review.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping("/create")
    public ResponseEntity createShop(@RequestBody ShopEntity shopEntity){
        try {
            shopService.addShop(shopEntity);
            return ResponseEntity.ok("Магазин успішно додано");
        } catch (ShopNameAlreadyExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping("/search/name")
    public ResponseEntity getShopByName(@RequestParam String name){
        try {
            return ResponseEntity.ok(shopService.getByName(name));
        } catch (ShopNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @GetMapping("/search")
    public ResponseEntity getShopById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(shopService.getById(id));
        } catch (ShopNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @PutMapping("/edit")
    public ResponseEntity editShopInfo(@RequestParam Long id,
                                       @RequestBody ShopEntity shopEntity){
        try {
            return ResponseEntity.ok("Дані про магазин були успішно додані");
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }
}
