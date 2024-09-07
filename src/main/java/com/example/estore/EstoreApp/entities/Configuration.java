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
@Table(name="configuration")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name= "_key")
    private String key;

    @Column(name= "_value")
    private String value;

    @Column(name= "created_at")
    private LocalDate created_at;

}
