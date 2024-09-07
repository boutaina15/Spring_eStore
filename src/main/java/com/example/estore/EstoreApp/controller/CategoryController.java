package com.example.estore.EstoreApp.controller;

import com.example.estore.EstoreApp.entities.Category;
import com.example.estore.EstoreApp.service.serviceImpl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;


    @GetMapping
    @CrossOrigin(origins ="http://localhost:4200")
    public List<Category> getCategories() {
        return categoryServiceImpl.getCategories();
    }

    @PostMapping("/add")
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryServiceImpl.addCategory(category)) ;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @DeleteMapping("/delete/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryServiceImpl.deleteCategory(categoryId);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody Category category) {
        return ResponseEntity.ok(categoryServiceImpl.updateCategory(categoryId, category)) ;
    }
}
