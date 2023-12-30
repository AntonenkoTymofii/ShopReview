package com.example.review.service;

import com.example.review.entity.ShopEntity;
import com.example.review.exception.categoryExceptions.CategoryNameAlreadyExistException;
import com.example.review.exception.shopException.ShopNameAlreadyExistException;
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
}
