package com.example.onlinestore.service;

import com.example.onlinestore.model.StoreLocation;

import java.util.List;

public interface StoreLocationService {


    /**
     * returns the location with the given id
     *
     * @param id The id of the location that we want to obtain
     * @return
     * @throws com.example.onlinestore.model.exceptions.InvalidStoreLocationIdException when there is no  location with the given id
     */
    StoreLocation findById(Long id);


    List<StoreLocation> listAll();


    StoreLocation create(String name);






}
