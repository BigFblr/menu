package com.example.k_dish.model.repositories;

import com.example.k_dish.model.entity.Cook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookRepository extends JpaRepository<Cook, Long> {
    List<Cook> findByName(String name);
    List<Cook> findByPhone(int phone);
}
