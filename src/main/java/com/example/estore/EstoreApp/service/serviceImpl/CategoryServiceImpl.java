package com.example.estore.EstoreApp.service.serviceImpl;

import com.example.estore.EstoreApp.dao.CategoryRepository;
import com.example.estore.EstoreApp.entities.Category;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        boolean exists = categoryRepository.existsById(categoryId);
        if (!exists) {
            throw new IllegalStateException("category with id " +categoryId+" does not exists");
        }
        categoryRepository.deleteById(categoryId);
        System.out.println("the category with id : "+categoryId+ " has been deleted succefully");

    }

    @Transactional
    public Category updateCategory(Long categoryId, Category categoryreq) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalStateException("category does not exists"));
        if (category != null){
            category.setCreated_at(categoryreq.getCreated_at());
            category.setName(categoryreq.getName());
            category.setPicture(categoryreq.getPicture());

            System.out.println("the category  has been updated succefully");

        }
        return categoryRepository.save(category);


    }


}
