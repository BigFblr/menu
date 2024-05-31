package com.example.k_dish.repositories;

import com.example.k_dish.model.entity.Cook;
import com.example.k_dish.model.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findByName(String name);
    List<Dish> findByCost(double cost);
    List<Dish> findByCook(Cook cook);
}
