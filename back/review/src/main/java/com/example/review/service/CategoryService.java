package com.example.review.service;

import com.example.review.entity.CategoryEntity;
import com.example.review.entity.UserEntity;
import com.example.review.exception.categoryExceptions.CategoryNameAlreadyExistException;
import com.example.review.exception.categoryExceptions.CategoryNotFoundException;
import com.example.review.exception.userExceptions.UserEmailAlreadyExistException;
import com.example.review.exception.userExceptions.UserNotFoundException;
import com.example.review.exception.userExceptions.UserPhoneAlreadyExistException;
import com.example.review.model.Category;
import com.example.review.model.User;
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

    public Category getCategoryById(Long id) throws CategoryNotFoundException {
        if(categoryRepo.findById(id).isEmpty()) {
            throw new CategoryNotFoundException("Такої категорії не найдено");
        }
        CategoryEntity categoryEntity = categoryRepo.findById(id).get();
        return Category.toModel(categoryEntity);
    }

    public Category getCategoryByName(String name) throws CategoryNotFoundException {
        if(categoryRepo.findByName(name) == null) {
            throw new CategoryNotFoundException("Такої категорії не найдено");
        }
        CategoryEntity categoryEntity = categoryRepo.findByName(name);
        return Category.toModel(categoryEntity);
    }

    public Long deleteCategory(Long id) throws CategoryNotFoundException {
        if (categoryRepo.findById(id).isEmpty()){
            throw new CategoryNotFoundException("Такої категорії вже не існує");
        }
        categoryRepo.deleteById(id);
        return id;
    }

    public void updateCategory(Long id, CategoryEntity category)
            throws CategoryNotFoundException, CategoryNameAlreadyExistException {
        if(categoryRepo.findById(id).isEmpty()){
            throw new CategoryNotFoundException("Такої категорії не існує");
        }
        CategoryEntity categoryEntity = categoryRepo.findById(id).get();

        categoryEntity.setName(category.getName());
        if (categoryRepo.findByName(categoryEntity.getName()) != null) {
            throw new CategoryNameAlreadyExistException("Категорія з таким ім'ям існує");
        }
        categoryRepo.save(categoryEntity);
    }
}
