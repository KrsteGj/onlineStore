package com.example.onlinestore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StoreLocation {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public StoreLocation(String name) {
        this.name = name;
    }

    public StoreLocation() {

    }
}
