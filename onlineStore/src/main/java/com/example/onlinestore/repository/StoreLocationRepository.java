package com.example.onlinestore.repository;

import com.example.onlinestore.model.StoreLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreLocationRepository extends JpaRepository<StoreLocation, Long> {
}
