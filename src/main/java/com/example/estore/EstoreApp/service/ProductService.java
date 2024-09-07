package com.example.estore.EstoreApp.service;

import com.example.estore.EstoreApp.entities.Product;

import java.util.List;

public interface ProductService {


    List<Product> getProducts();

    void deleteProduct(Long productId);

    Product updateProduct(Long productId, Product productreq);

    Product addProduct(Product product);

}
