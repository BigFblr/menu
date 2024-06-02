package com.example.k_dish.service.impl;

import com.example.k_dish.model.entity.Ingredients;
import com.example.k_dish.repositories.IngredientsRepository;
import com.example.k_dish.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Override
    public Ingredients read(Long id) {
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
    public void delete(Long id) {
        ingredientsRepository.deleteById(id);
    }

    @Override
    public List<Ingredients> readByName(String name) {
        return ingredientsRepository.findByName(name);
    }
    @Override
    public List<Ingredients> getAllIngredients() {
        return ingredientsRepository.findAll();
    }
    @Override
    public List<Ingredients> update(Long ingredientId, Ingredients updatedIngredient) {
        Ingredients existingIngredient = ingredientsRepository.findById(ingredientId)
                .orElseThrow(() -> new IllegalArgumentException("Ingredient not found with ID: " + ingredientId));
        ingredientsRepository.save(existingIngredient);
        return ingredientsRepository.findAll();
    }
}
