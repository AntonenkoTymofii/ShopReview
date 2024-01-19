package com.example.review.service;

import com.example.review.model.ShopModel;
import com.example.review.exception.shopException.ShopNameAlreadyExistException;
import com.example.review.exception.shopException.ShopNotFoundException;
import com.example.review.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    private ShopRepo shopRepo;

    public void addShop(ShopModel shopModel) throws ShopNameAlreadyExistException {
        if (shopRepo.findByName(shopModel.getName()) != null){
            throw new ShopNameAlreadyExistException(
                    "Магазин з такою назвою існує"
            );
        }
        shopRepo.save(shopModel);
    }

    public ShopModel getByName(String name) throws ShopNotFoundException {
        if (shopRepo.findByName(name) == null){
            throw new ShopNotFoundException(
                    "Магазину з такою назвою не існує"
            );
        }
        ShopModel shopModel = shopRepo.findByName(name);
        return ShopModel.toModel(shopModel);
    }

    public ShopModel getById(Long id) throws ShopNotFoundException {
        if (shopRepo.findById(id).isEmpty()){
            throw new ShopNotFoundException(
                    "Магазину не найдено"
            );
        }
        ShopModel shopModel = shopRepo.findById(id).get();
        return ShopModel.toModel(shopModel);
    }

    public void editShopInfo(Long id, ShopModel shopModel)
            throws ShopNotFoundException, ShopNameAlreadyExistException {

        if (shopRepo.findById(id).isEmpty()){
            throw new ShopNotFoundException(
                    "Магазину не найдено"
            );
        }

        ShopModel shop = shopRepo.findById(id).get();
        shop.setName(shopModel.getName());
        shop.setAddress(shopModel.getAddress());
        shop.setQuantity(shopModel.getQuantity());

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
