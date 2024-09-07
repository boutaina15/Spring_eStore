package com.example.estore.EstoreApp.service.serviceImpl;

import com.example.estore.EstoreApp.dao.GalleryRepository;
import com.example.estore.EstoreApp.entities.Gallery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GalleryServiceImpl {

    private final GalleryRepository galleryRepository;

    public List<Gallery> getGalleries(){
        return galleryRepository.findAll();
    }

    public Gallery addGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    public void deleteGallery(Long galleryId) {
        boolean exists = galleryRepository.existsById(galleryId);
        if (!exists) {
            throw new IllegalStateException("gallery with id " +galleryId+" does not exists");
        }
        galleryRepository.deleteById(galleryId);
        System.out.println("the gallery with id : "+galleryId+ " has been deleted succefully");

    }

    @Transactional
    public Gallery updateGallery(Long galleryId, Gallery galleryreq) {
        Gallery gallery = galleryRepository.findById(galleryId).orElseThrow(() -> new IllegalStateException("gallery does not exists"));
        if (gallery != null){
            gallery.setCreated_at(galleryreq.getCreated_at());
            gallery.setData(galleryreq.getData());
            gallery.setType(galleryreq.getType());
            gallery.setName(galleryreq.getName());

            System.out.println("the gallery  has been updated succefully");

        }
        return galleryRepository.save(gallery);


    }
}
