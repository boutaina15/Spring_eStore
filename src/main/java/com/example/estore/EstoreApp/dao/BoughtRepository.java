package com.example.estore.EstoreApp.dao;

import com.example.estore.EstoreApp.entities.Bought;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtRepository extends JpaRepository<Bought, Long> {
}
