package com.example.k_dish.service.impl;

import com.example.k_dish.model.entity.Ingredients;
import com.example.k_dish.model.repositories.IngredientsRepository;
import com.example.k_dish.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Override
    public Ingredients read(Integer id) {
        return ingredientsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ingredients> read() {
        return ingredientsRepository.findAll();
    }

    @Override
    public void save(Ingredients ingredients) {
        ingredientsRepository.save(ingredients);
    }

    @Override
    public void delete(Integer id) {
        ingredientsRepository.deleteById(id);
    }

    @Override
    public List<Ingredients> readByName(String name) {
        return ingredientsRepository.findByName(name);
    }
}
