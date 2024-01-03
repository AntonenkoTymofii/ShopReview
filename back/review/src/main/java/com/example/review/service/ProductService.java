package com.example.review.service;

import com.example.review.entity.ProductEntity;
import com.example.review.exception.productExceptions.ProductNotFoundException;
import com.example.review.model.Product;
import com.example.review.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void createProduct(ProductEntity productEntity) {
        productRepo.save(productEntity);
    }

    public Product getProductById(Long id)
            throws ProductNotFoundException {
        if(productRepo.findById(id).isEmpty()) {
            throw new ProductNotFoundException("Такого продукта не найдено");
        }
        ProductEntity productEntity = productRepo.findById(id).get();
        return Product.toModel(productEntity);
    }

    public List<ProductEntity> getProductByName(String name) throws ProductNotFoundException {
        if(productRepo.findByName(name).isEmpty()) {
            throw new ProductNotFoundException("Продукта/продукти не найдено");
        }
        return productRepo.findByName(name);
    }

    public Long deleteProduct(Long id)
            throws ProductNotFoundException {
        if(productRepo.findById(id).isEmpty()) {
            throw new ProductNotFoundException("Такого продукта вже не існує");
        }
        productRepo.deleteById(id);
        return id;
    }

    public void updateProduct(Long id, ProductEntity product)
            throws ProductNotFoundException {
        if(productRepo.findById(id).isEmpty()){
            throw new ProductNotFoundException("Такого продукта не існує");
        }
        ProductEntity productEntity = productRepo.findById(id).get();

        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productRepo.save(productEntity);
    }
}
