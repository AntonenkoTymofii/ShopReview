package com.example.review.service;

import com.example.review.entity.PurchaseEntity;
import com.example.review.entity.ShopEntity;
import com.example.review.exception.purchaseException.PurchaseNotFoundException;
import com.example.review.exception.shopException.ShopNotFoundException;
import com.example.review.model.Purchase;
import com.example.review.repository.PurchaseRepo;
import com.example.review.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepo purchaseRepo;

    @Autowired
    private ShopRepo shopRepo;

    public void createPurchase(PurchaseEntity purchaseEntity, Long shopId) throws ShopNotFoundException {
        if(shopRepo.findById(shopId).isEmpty()){
            throw new ShopNotFoundException("Магазин не найдено");
        }
        purchaseEntity.setShop(shopRepo.findById(shopId).get());
        purchaseRepo.save(purchaseEntity);
    }

    public Purchase getPurchaseById(Long id) throws PurchaseNotFoundException {
        if(purchaseRepo.findById(id).isEmpty()) {
            throw new PurchaseNotFoundException("Такої покупки не найдено");
        }
        PurchaseEntity purchaseEntity = purchaseRepo.findById(id).get();
        return Purchase.toModel(purchaseEntity);
    }

//    public void getPurchaseByShop(ShopEntity shop){
//        purchaseRepo.save(purchaseEntity);
//    }
//
//    public void getPurchaseByDate(Date date){
//        purchaseRepo.save(purchaseEntity);
//    }


}
