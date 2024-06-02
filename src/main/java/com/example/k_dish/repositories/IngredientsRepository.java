package com.example.k_dish.repositories;

import com.example.k_dish.model.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
    List<Ingredients> findByName(String name);

}
