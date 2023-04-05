package com.example.onlinestore.config;

import com.example.onlinestore.model.BrandType;
import com.example.onlinestore.service.HatService;
import com.example.onlinestore.service.StoreLocationService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final StoreLocationService storeLocationService;

    private final HatService hatService;

    public DataInitializer(StoreLocationService storeLocationService, HatService hatService) {
        this.storeLocationService = storeLocationService;
        this.hatService = hatService;
    }

    private BrandType randomizeEventType(int i) {
        if(i % 3 == 0) return BrandType.ADIDAS;
        else if(i % 3 == 1) return BrandType.TOMMY_HILFIGER;
        return BrandType.NIKE;
    }

    @PostConstruct
    public void initData() {
        for (int i = 1; i < 6; i++) {
            this.storeLocationService.create("Store Location: " + i);
        }

        for (int i = 1; i < 11; i++) {
            this.hatService.create("Hat: " + i, "Hat description: " + i , 20.9 * i, this.randomizeEventType(i), this.storeLocationService.listAll().get((i-1)%5).getId());
        }
    }
}

