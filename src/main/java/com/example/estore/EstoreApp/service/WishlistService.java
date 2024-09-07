package com.example.estore.EstoreApp.service;

import com.example.estore.EstoreApp.entities.Wishlist;

import java.util.List;

public interface WishlistService {


    List<Wishlist> getWishlists();

    void deleteWishlist(Long wishlistId);

    Wishlist updateWishlist(Long wishlistId, Wishlist wishlistreq);

    Wishlist addWishlist(Wishlist wishlist);

}
