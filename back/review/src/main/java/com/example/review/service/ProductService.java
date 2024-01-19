package com.example.review.service;

import com.example.review.model.ProductModel;
import com.example.review.exception.productExceptions.ProductNotFoundException;
import com.example.review.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void createProduct(ProductModel productModel) {
        productRepo.save(productModel);
    }

    public ProductModel getProductById(Long id)
            throws ProductNotFoundException {
        if(productRepo.findById(id).isEmpty()) {
            throw new ProductNotFoundException("Такого продукта не найдено");
        }
        ProductModel productModel = productRepo.findById(id).get();
        return ProductModel.toModel(productModel);
    }

    public List<ProductModel> getProductByName(String name) throws ProductNotFoundException {
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

    public void updateProduct(Long id, ProductModel product)
            throws ProductNotFoundException {
        if(productRepo.findById(id).isEmpty()){
            throw new ProductNotFoundException("Такого продукта не існує");
        }
        ProductModel productModel = productRepo.findById(id).get();

        productModel.setName(product.getName());
        productModel.setPrice(product.getPrice());
        productRepo.save(productModel);
    }
}
