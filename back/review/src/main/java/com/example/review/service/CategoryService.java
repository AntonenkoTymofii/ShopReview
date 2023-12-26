package com.example.review.service;

import com.example.review.entity.CategoryEntity;
import com.example.review.exception.CategoryNameAlreadyExistException;
import com.example.review.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public void createCategory(CategoryEntity categoryEntity)
            throws CategoryNameAlreadyExistException {
        if (categoryRepo.findByName(categoryEntity.getName()) != null){
            throw new CategoryNameAlreadyExistException(
                "Категорія з таким ім'ям існує"
            );
        }
        categoryRepo.save(categoryEntity);
    }
}
