package com.example.estore.EstoreApp.service.serviceImpl;

import com.example.estore.EstoreApp.dao.BoughtRepository;
import com.example.estore.EstoreApp.entities.Bought;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoughtServiceImpl {

    private final BoughtRepository boughtRepository;

    public List<Bought> getBoughts(){
        return boughtRepository.findAll();
    }

    public Bought addBought(Bought bought) {
        return boughtRepository.save(bought);
    }

    public void deleteBought(Long boughtId) {
        boolean exists = boughtRepository.existsById(boughtId);
        if (!exists) {
            throw new IllegalStateException("bought with id " +boughtId+" does not exists");
        }
        boughtRepository.deleteById(boughtId);
        System.out.println("the bought with id : "+boughtId+ " has been deleted succefully");

    }

    @Transactional
    public Bought updateBought(Long boughtId, Bought boughtreq) {
        Bought bought = boughtRepository.findById(boughtId).orElseThrow(() -> new IllegalStateException("bought does not exists"));
        if (bought != null){
            bought.setCreated_at(boughtreq.getCreated_at());
            bought.setUser(boughtreq.getUser());
            bought.setProducts(boughtreq.getProducts());
            System.out.println("the bought  has been updated succefully");

        }
        return boughtRepository.save(bought);


    }
}
