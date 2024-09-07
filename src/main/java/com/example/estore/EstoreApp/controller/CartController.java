package com.example.estore.EstoreApp.controller;

import com.example.estore.EstoreApp.entities.Cart;
import com.example.estore.EstoreApp.service.serviceImpl.CartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartServiceImpl cartServiceImpl;


    @GetMapping
    @CrossOrigin(origins ="http://localhost:4200")
    public List<Cart> getCarts() {
        return cartServiceImpl.getCarts();
    }

    @PostMapping("/add")
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartServiceImpl.addCart(cart)) ;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @DeleteMapping("/delete/{cartId}")
    public void deleteCart(@PathVariable("cartId") Long cartId) {
        cartServiceImpl.deleteCart(cartId);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/update/{cartId}")
    public ResponseEntity<Cart> updateCart(@PathVariable("cartId") Long cartId, @RequestBody Cart cart) {
        return ResponseEntity.ok(cartServiceImpl.updateCart(cartId, cart)) ;
    }
}
