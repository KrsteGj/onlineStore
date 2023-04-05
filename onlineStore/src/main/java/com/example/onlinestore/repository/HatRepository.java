package com.example.onlinestore.repository;

import com.example.onlinestore.model.Hat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HatRepository extends JpaRepository<Hat, Long> {
}
