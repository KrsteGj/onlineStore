package com.example.onlinestore.service;

import com.example.onlinestore.model.BrandType;
import com.example.onlinestore.model.Hat;

import java.util.List;

public interface HatService {



    List<Hat> listAllHats();


    Hat findById(Long id);


    Hat create(String name, String description, Double price, BrandType type, Long location);


    Hat update(Long id, String name, String description, Double price, BrandType type, Long location);


    Hat delete(Long id);





    List<Hat> listMatchesWithPriceLessThanAndType(Double price, BrandType type);
}
