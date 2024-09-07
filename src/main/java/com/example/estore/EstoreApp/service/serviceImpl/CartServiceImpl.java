package com.example.estore.EstoreApp.service.serviceImpl;

import com.example.estore.EstoreApp.dao.BoughtRepository;
import com.example.estore.EstoreApp.dao.CartRepository;
import com.example.estore.EstoreApp.entities.Bought;
import com.example.estore.EstoreApp.entities.Cart;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartServiceImpl {

    private final CartRepository cartRepository;

    public List<Cart> getCarts(){
        return cartRepository.findAll();
    }

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(Long cartId) {
        boolean exists = cartRepository.existsById(cartId);
        if (!exists) {
            throw new IllegalStateException("cart with id " +cartId+" does not exists");
        }
        cartRepository.deleteById(cartId);
        System.out.println("the cart with id : "+cartId+ " has been deleted succefully");

    }

    @Transactional
    public Cart updateCart(Long cartId, Cart cartreq) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalStateException("cart does not exists"));
        if (cart != null){

            cart.setCreated_at(cartreq.getCreated_at());

            System.out.println("the cart  has been updated succefully");

        }
        return cartRepository.save(cart);


    }
}
