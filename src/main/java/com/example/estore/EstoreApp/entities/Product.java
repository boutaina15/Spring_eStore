package com.example.estore.EstoreApp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "soldQte")
    private int soldQte;

    @Column(name = "brand")
    private String brand;

    @Column(name = "rating")
    private String rating;

    @Column(name = "shortDescription")
    private String shortDescription;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private byte[] picture;

    @Column(name = "discountPercentage")
    private Double discountPercentage;

    @Column(name = "discount")
    private boolean discount;

    @Column(name = "discountStart")
    private Date discountStart;

    @Column(name = "discountEnd")
    private Date discountEnd;

    @Column(name = "color")
    private String color;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "bought_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "bought_id"))
    Set<Bought> boughts;

    @ManyToMany
    @JoinTable(
            name = "wishlist_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "wishlist_id"))
    Set<Wishlist> wishlists;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id"))
    Set<Cart> carts;


    public Category getDiscount() {
        return null;
    }
}
