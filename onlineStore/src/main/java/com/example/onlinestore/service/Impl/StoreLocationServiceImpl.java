package com.example.onlinestore.service.Impl;

import com.example.onlinestore.model.StoreLocation;
import com.example.onlinestore.model.exceptions.InvalidStoreLocationIdException;
import com.example.onlinestore.repository.StoreLocationRepository;
import com.example.onlinestore.service.StoreLocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreLocationServiceImpl implements StoreLocationService {

    private final StoreLocationRepository storeLocationRepository;

    public StoreLocationServiceImpl(StoreLocationRepository storeLocationRepository) {
        this.storeLocationRepository = storeLocationRepository;
    }

    @Override
    public StoreLocation findById(Long id) {
        return this.storeLocationRepository.findById(id).orElseThrow(InvalidStoreLocationIdException::new);
    }

    @Override
    public List<StoreLocation> listAll() {
        return this.storeLocationRepository.findAll();
    }

    @Override
    public StoreLocation create(String name) {
        StoreLocation storeLocation = new StoreLocation(name);
        return this.storeLocationRepository.save(storeLocation);
    }
}
