package com.example.estore.EstoreApp.service.serviceImpl;

import com.example.estore.EstoreApp.dao.WishlistRepository;
import com.example.estore.EstoreApp.entities.Wishlist;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WishlistServiceImpl {

    private final WishlistRepository wishlistRepository;

    public List<Wishlist> getWishlists(){
        return wishlistRepository.findAll();
    }

    public Wishlist addWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public void deleteWishlist(Long wishlistId) {
        boolean exists = wishlistRepository.existsById(wishlistId);
        if (!exists) {
            throw new IllegalStateException("wishlist with id " +wishlistId+" does not exists");
        }
        wishlistRepository.deleteById(wishlistId);
        System.out.println("the wishlist with id : "+wishlistId+ " has been deleted succefully");

    }

    @Transactional
    public Wishlist updateWishlist(Long wishlistId, Wishlist wishlistreq) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow(() -> new IllegalStateException("wishlist does not exists"));
        if (wishlist != null){

            wishlist.setCreated_at(wishlistreq.getCreated_at());
            wishlist.setUser(wishlistreq.getUser());
            wishlist.setProducts(wishlistreq.getProducts());

            System.out.println("the wishlist  has been updated succefully");

        }
        return wishlistRepository.save(wishlist);


    }
}
