package com.example.estore.EstoreApp.service.serviceImpl;

import com.example.estore.EstoreApp.dao.ProductRepository;
import com.example.estore.EstoreApp.entities.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl {

    private final ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new IllegalStateException("product with id " +productId+" does not exists");
        }
        productRepository.deleteById(productId);
        System.out.println("the product with id : "+productId+ " has been deleted succefully");

    }

    @Transactional
    public Product updateProduct(Long productId, Product productreq) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException("product does not exists"));
        if (product != null){
            product.setBrand(productreq.getBrand());

            product.setUpdatedAt(productreq.getUpdatedAt());
            product.setColor(productreq.getBrand());
            product.setCarts(productreq.getCarts());
            product.setCreatedAt(productreq.getCreatedAt());
            product.setDescription(productreq.getDescription());
            product.setBoughts(productreq.getBoughts());
            product.setDiscountEnd(productreq.getDiscountEnd());
            product.setDiscountPercentage(productreq.getDiscountPercentage());
            product.setDiscountStart(productreq.getDiscountStart());
            product.setCategory(productreq.getDiscount());
            product.setPicture(productreq.getPicture());
            product.setPrice(productreq.getPrice());
            product.setQuantity(productreq.getQuantity());
            product.setRating(productreq.getRating());
            product.setShortDescription(productreq.getShortDescription());
            product.setSoldQte(productreq.getSoldQte());
            product.setTitle(productreq.getTitle());
            System.out.println("the product  has been updated succefully");

        }
        return productRepository.save(product);


    }
}
