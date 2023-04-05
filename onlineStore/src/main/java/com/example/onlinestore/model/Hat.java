package com.example.onlinestore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Hat {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private Double price;

    @Enumerated(EnumType.STRING)
    private BrandType type;

    @ManyToOne
    private StoreLocation location;


    public Hat()
    {

    }

    public Hat(String name, String description, Double price, BrandType type, StoreLocation location) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.location = location;
    }
}
