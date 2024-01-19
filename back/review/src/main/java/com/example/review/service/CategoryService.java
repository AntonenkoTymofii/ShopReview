package com.example.review.service;

import com.example.review.model.CategoryModel;
import com.example.review.exception.categoryExceptions.CategoryNameAlreadyExistException;
import com.example.review.exception.categoryExceptions.CategoryNotFoundException;
import com.example.review.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public void createCategory(CategoryModel categoryModel)
            throws CategoryNameAlreadyExistException {
        if (categoryRepo.findByName(categoryModel.getName()) != null){
            throw new CategoryNameAlreadyExistException(
                "Категорія з таким ім'ям існує"
            );
        }
        categoryRepo.save(categoryModel);
    }

    public CategoryModel getCategoryById(Long id) throws CategoryNotFoundException {
        if(categoryRepo.findById(id).isEmpty()) {
            throw new CategoryNotFoundException("Такої категорії не найдено");
        }
        CategoryModel categoryModel = categoryRepo.findById(id).get();
        return CategoryModel.toModel(categoryModel);
    }

    public CategoryModel getCategoryByName(String name) throws CategoryNotFoundException {
        if(categoryRepo.findByName(name) == null) {
            throw new CategoryNotFoundException("Такої категорії не найдено");
        }
        CategoryModel categoryModel = categoryRepo.findByName(name);
        return CategoryModel.toModel(categoryModel);
    }

    public Long deleteCategory(Long id) throws CategoryNotFoundException {
        if (categoryRepo.findById(id).isEmpty()){
            throw new CategoryNotFoundException("Такої категорії вже не існує");
        }
        categoryRepo.deleteById(id);
        return id;
    }

    public void updateCategory(Long id, CategoryModel category)
            throws CategoryNotFoundException, CategoryNameAlreadyExistException {
        if(categoryRepo.findById(id).isEmpty()){
            throw new CategoryNotFoundException("Такої категорії не існує");
        }
        CategoryModel categoryModel = categoryRepo.findById(id).get();

        categoryModel.setName(category.getName());
        if (categoryRepo.findByName(categoryModel.getName()) != null) {
            throw new CategoryNameAlreadyExistException("Категорія з таким ім'ям існує");
        }
        categoryRepo.save(categoryModel);
    }
}
