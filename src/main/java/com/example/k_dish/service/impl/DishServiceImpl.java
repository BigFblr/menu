package com.example.k_dish.service.impl;

import com.example.k_dish.model.entity.Dish;
import com.example.k_dish.model.entity.Cook;
import com.example.k_dish.repositories.DishRepository;
import com.example.k_dish.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;

    @Override
    public Dish read(Long id) {
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
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public List<Dish> readByName(String name) {
        return dishRepository.findByName(name);
    }

    @Override
    public List<Dish> readByCost(double cost) {
        return dishRepository.findByCost(cost);
    }
    @Override
    public List<Dish> readByMenu(Long menuId) {
        return dishRepository.findByMenuId(menuId);
    }
}
