package com.example.estore.EstoreApp.controller;

import com.example.estore.EstoreApp.entities.Gallery;
import com.example.estore.EstoreApp.service.serviceImpl.GalleryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/gallery")
@RequiredArgsConstructor
public class GalleryController {

    private final GalleryServiceImpl galleryServiceImpl;


    @GetMapping
    @CrossOrigin(origins ="http://localhost:4200")
    public List<Gallery> getGalleries() {
        return galleryServiceImpl.getGalleries();
    }

    @PostMapping("/add")
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<Gallery> addGallery(@RequestBody Gallery gallery) {
        return ResponseEntity.ok(galleryServiceImpl.addGallery(gallery)) ;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @DeleteMapping("/delete/{galleryId}")
    public void deleteGallery(@PathVariable("galleryId") Long galleryId) {
        galleryServiceImpl.deleteGallery(galleryId);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/update/{galleryId}")
    public ResponseEntity<Gallery> updateGallery(@PathVariable("galleryId") Long galleryId, @RequestBody Gallery gallery) {
        return ResponseEntity.ok(galleryServiceImpl.updateGallery(galleryId, gallery)) ;
    }
}
