package com.example.estore.EstoreApp.service;

import com.example.estore.EstoreApp.entities.Gallery;

import java.util.List;

public interface GalleryService {

    List<Gallery> getGalleries();

    void deleteGallery(Long galleryId);

    Gallery updateGallery(Long galleryId, Gallery galleryreq);

    Gallery addGallery(Gallery gallery);

}
