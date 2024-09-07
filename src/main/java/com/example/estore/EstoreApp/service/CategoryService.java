package com.example.estore.EstoreApp.service;

import com.example.estore.EstoreApp.entities.Category;

import java.util.List;

public interface CategoryService {


    List<Category> getCategories();

    void deleteCategory(Long categoryId);

    Category updateCategory(Long categoryId, Category categoryreq);

    Category addCategory(Category category);

}
