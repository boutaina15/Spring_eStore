package com.example.estore.EstoreApp.service;

import com.example.estore.EstoreApp.entities.Bought;

import java.util.List;

public interface BoughtService {


    List<Bought> getBoughts();

    void deleteBought(Long boughtId);

    Bought updateBought(Long boughtId, Bought boughtreq);

    Bought addBought(Bought bought);

}
