package com.example.k_dish.service;

import com.example.k_dish.model.entity.Dish;
import java.util.List;

public interface DishService extends Service<Dish> {
    List<Dish> readByName(String name);
    List<Dish> readByCost(float cost);
}
