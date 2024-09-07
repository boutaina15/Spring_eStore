package com.example.estore.EstoreApp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name= "picture")
    private byte[] picture;

    @Column(name= "created_at")
    private LocalDateTime created_at;


    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }

}
