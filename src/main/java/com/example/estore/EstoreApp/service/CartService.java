package com.example.estore.EstoreApp.service;

import com.example.estore.EstoreApp.entities.Cart;

import java.util.List;

public interface CartService {


    List<Cart> getCarts();

    void deleteCart(Long cartId);

    Cart updateCart(Long cartId, Cart cartreq);

    Cart addCart(Cart cart);

}
