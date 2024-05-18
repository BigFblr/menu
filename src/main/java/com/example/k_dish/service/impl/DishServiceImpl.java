package com.example.k_dish.service.impl;

import com.example.k_dish.model.entity.Dish;
import com.example.k_dish.model.repositories.DishRepository;
import com.example.k_dish.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;

    @Override
    public Dish read(Integer id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dish> read() {
        return dishRepository.findAll();
    }

    @Override
    public void save(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public void delete(Integer id) {
        dishRepository.deleteById(id);
    }

    @Override
    public List<Dish> readByName(String name) {
        return dishRepository.findByName(name);
    }

    @Override
    public List<Dish> readByCost(float cost) {
        return dishRepository.findByCost(cost);
    }
}
