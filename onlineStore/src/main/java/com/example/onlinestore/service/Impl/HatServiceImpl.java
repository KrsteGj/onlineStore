package com.example.onlinestore.service.Impl;

import com.example.onlinestore.model.BrandType;
import com.example.onlinestore.model.Hat;
import com.example.onlinestore.model.StoreLocation;
import com.example.onlinestore.model.exceptions.InvalidHatIdException;
import com.example.onlinestore.repository.HatRepository;
import com.example.onlinestore.service.HatService;
import com.example.onlinestore.service.StoreLocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HatServiceImpl implements HatService {


    private final HatRepository hatRepository;
    private final StoreLocationService storeLocationService;

    public HatServiceImpl(HatRepository hatRepository, StoreLocationService storeLocationService) {
        this.hatRepository = hatRepository;
        this.storeLocationService = storeLocationService;
    }

    @Override
    public List<Hat> listAllHats() {
        return this.hatRepository.findAll();
    }

    @Override
    public Hat findById(Long id) {
        return this.hatRepository.findById(id).orElseThrow(InvalidHatIdException::new);
    }

    @Override
    public Hat create(String name, String description, Double price, BrandType type, Long location) {
        StoreLocation storeLocation = this.storeLocationService.findById(location);
        Hat hat = new Hat(name, description, price, type, storeLocation);
        return this.hatRepository.save(hat);
    }

    @Override
    public Hat update(Long id, String name, String description, Double price, BrandType type, Long location) {
        Hat hat = this.findById(id);
        StoreLocation storeLocation = this.storeLocationService.findById(location);
        hat.setName(name);
        hat.setDescription(description);
        hat.setPrice(price);
        hat.setType(type);
        hat.setLocation(storeLocation);
        return this.hatRepository.save(hat);
    }

    @Override
    public Hat delete(Long id) {
        Hat hat = this.findById(id);
        this.hatRepository.delete(hat);
        return this.hatRepository.save(hat);
    }


    @Override
    public List<Hat> listMatchesWithPriceLessThanAndType(Double price, BrandType type) {
        return null;
    }
}
