package com.example.k_dish.service;

import com.example.k_dish.model.entity.Ingredients;
import java.util.List;

public interface IngredientsService extends Service<Ingredients> {
    List<Ingredients> readByName(String name);
}
