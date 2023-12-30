package com.example.review.service;

import com.example.review.entity.ShopEntity;
import com.example.review.exception.categoryExceptions.CategoryNameAlreadyExistException;
import com.example.review.exception.shopException.ShopNameAlreadyExistException;
import com.example.review.exception.shopException.ShopNotFoundException;
import com.example.review.model.Shop;
import com.example.review.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    ShopRepo shopRepo;

    public void addShop(ShopEntity shopEntity) throws ShopNameAlreadyExistException {
        if (shopRepo.findByName(shopEntity.getName()) != null){
            throw new ShopNameAlreadyExistException(
                    "Магазин з такою назвою існує"
            );
        }
        shopRepo.save(shopEntity);
    }

    public Shop getByName(String name) throws ShopNotFoundException {
        if (shopRepo.findByName(name) == null){
            throw new ShopNotFoundException(
                    "Магазину з такою назвою не існує"
            );
        }
        ShopEntity shopEntity = shopRepo.findByName(name);
        return Shop.toModel(shopEntity);
    }

    public Shop getById(Long id) throws ShopNotFoundException {
        if (shopRepo.findById(id).isEmpty()){
            throw new ShopNotFoundException(
                    "Магазину не найдено"
            );
        }
        ShopEntity shopEntity = shopRepo.findById(id).get();
        return Shop.toModel(shopEntity);
    }

    public void editShopInfo(Long id, ShopEntity shopEntity)
            throws ShopNotFoundException, ShopNameAlreadyExistException {

        if (shopRepo.findById(id).isEmpty()){
            throw new ShopNotFoundException(
                    "Магазину не найдено"
            );
        }

        ShopEntity shop = shopRepo.findById(id).get();
        shop.setName(shopEntity.getName());
        shop.setAddress(shopEntity.getAddress());
        shop.setQuantity(shopEntity.getQuantity());

        if (shopRepo.findByName(shop.getName()) != null) {
            throw new ShopNameAlreadyExistException(
                    "Магазин з такою назвою вже існує"
            );
        }

        shopRepo.save(shop);
    }

    public Long deleteShop(Long id) throws ShopNotFoundException {
        if (shopRepo.findById(id).isEmpty()){
            throw new ShopNotFoundException(
                    "Магазину не найдено"
            );
        }
        shopRepo.deleteById(id);
        return id;
    }

}
