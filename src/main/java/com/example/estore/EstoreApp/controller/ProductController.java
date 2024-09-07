package com.example.estore.EstoreApp.controller;

import com.example.estore.EstoreApp.entities.Product;
import com.example.estore.EstoreApp.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productServiceImpl;


    @GetMapping
    @CrossOrigin(origins ="http://localhost:4200")
    public List<Product> getProducts() {
        return productServiceImpl.getProducts();
    }

    @PostMapping("/add")
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productServiceImpl.addProduct(product)) ;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productServiceImpl.deleteProduct(productId);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product) {
        return ResponseEntity.ok(productServiceImpl.updateProduct(productId, product)) ;
    }
}
