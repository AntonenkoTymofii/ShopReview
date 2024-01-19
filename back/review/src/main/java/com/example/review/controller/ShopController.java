package com.example.review.controller;

import com.example.review.model.ShopModel;
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
    private ShopService shopService;

    @PostMapping("/create")
    public ResponseEntity createShop(@RequestBody ShopModel shopModel){
        try {
            shopService.addShop(shopModel);
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
                                       @RequestBody ShopModel shopModel){
        try {
            shopService.editShopInfo(id, shopModel);
            return ResponseEntity.ok("Дані про магазин були успішно оновлені");
        } catch (ShopNotFoundException | ShopNameAlreadyExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteShop(@PathVariable Long id){
        try {
            return ResponseEntity.ok("Було успішно видалено інформацію" +
                    " про магазин з іd: " + shopService.deleteShop(id));
        } catch (ShopNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.badRequest().body("Відбулась помилка");
        }
    }
}
