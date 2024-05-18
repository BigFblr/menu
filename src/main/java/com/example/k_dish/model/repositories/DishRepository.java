package com.example.k_dish.model.repositories;

import com.example.k_dish.model.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findByName(String name);
    List<Dish> findByCost(float cost);
}
