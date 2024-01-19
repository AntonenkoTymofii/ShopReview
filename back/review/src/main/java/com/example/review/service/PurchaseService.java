package com.example.review.service;

import com.example.review.model.PurchaseModel;
import com.example.review.exception.purchaseException.PurchaseNotFoundException;
import com.example.review.exception.shopException.ShopNotFoundException;
import com.example.review.repository.PurchaseRepo;
import com.example.review.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepo purchaseRepo;

    @Autowired
    private ShopRepo shopRepo;

    public void createPurchase(PurchaseModel purchaseModel, Long shopId) throws ShopNotFoundException {
        if(shopRepo.findById(shopId).isEmpty()){
            throw new ShopNotFoundException("Магазин не найдено");
        }
        purchaseModel.setShop(shopRepo.findById(shopId).get());
        purchaseRepo.save(purchaseModel);
    }

    public PurchaseModel getPurchaseById(Long id) throws PurchaseNotFoundException {
        if(purchaseRepo.findById(id).isEmpty()) {
            throw new PurchaseNotFoundException("Такої покупки не найдено");
        }
        PurchaseModel purchaseModel = purchaseRepo.findById(id).get();
        return PurchaseModel.toModel(purchaseModel);
    }

//    public void getPurchaseByShop(ShopEntity shop){
//        purchaseRepo.save(purchaseEntity);
//    }
//
//    public void getPurchaseByDate(Date date){
//        purchaseRepo.save(purchaseEntity);
//    }


}
