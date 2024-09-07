package com.example.estore.EstoreApp.controller;

import com.example.estore.EstoreApp.entities.Bought;
import com.example.estore.EstoreApp.service.serviceImpl.BoughtServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bought")
@RequiredArgsConstructor
public class BoughtController {

    private final BoughtServiceImpl boughtServiceImpl;


    @GetMapping
    @CrossOrigin(origins ="http://localhost:4200")
    public List<Bought> getBoughts() {
        return boughtServiceImpl.getBoughts();
    }

    @PostMapping("/add")
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<Bought> addBought(@RequestBody Bought bought) {
        return ResponseEntity.ok(boughtServiceImpl.addBought(bought)) ;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @DeleteMapping("/delete/{boughtId}")
    public void deleteBought(@PathVariable("boughtId") Long boughtId) {
        boughtServiceImpl.deleteBought(boughtId);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/update/{boughtId}")
    public ResponseEntity<Bought> updateBought(@PathVariable("boughtId") Long boughtId, @RequestBody Bought bought) {
        return ResponseEntity.ok(boughtServiceImpl.updateBought(boughtId, bought)) ;
    }
}
