package com.example.estore.EstoreApp.controller;

import com.example.estore.EstoreApp.entities.Wishlist;
import com.example.estore.EstoreApp.service.serviceImpl.WishlistServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistServiceImpl wishlistServiceImpl;


    @GetMapping
    @CrossOrigin(origins ="http://localhost:4200")
    public List<Wishlist> getWishlists() {
        return wishlistServiceImpl.getWishlists();
    }

    @PostMapping("/add")
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<Wishlist> addWishlist(@RequestBody Wishlist wishlist) {
        return ResponseEntity.ok(wishlistServiceImpl.addWishlist(wishlist)) ;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @DeleteMapping("/delete/{wishlistId}")
    public void deleteWishlist(@PathVariable("wishlistId") Long wishlistId) {
        wishlistServiceImpl.deleteWishlist(wishlistId);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/update/{wishlistId}")
    public ResponseEntity<Wishlist> updateWishlist(@PathVariable("wishlistId") Long wishlistId, @RequestBody Wishlist wishlist) {
        return ResponseEntity.ok(wishlistServiceImpl.updateWishlist(wishlistId, wishlist)) ;
    }
}
