package com.example.estore.EstoreApp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate created_at;

}
