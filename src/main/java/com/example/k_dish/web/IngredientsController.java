package com.example.k_dish.web;

import com.example.k_dish.model.entity.Ingredients;
import com.example.k_dish.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ingredients")
public class IngredientsController extends AbstractController<Ingredients> {
    @Autowired
    private final IngredientsService ingredientsService;

    @Autowired
    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Ingredients>> getIngredientsByName(@PathVariable String name) {
        List<Ingredients> ingredients = ingredientsService.readByName(name);
        if (ingredients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ingredients, headers, HttpStatus.OK);
    }

    @Override
    public IngredientsService getService() {
        return ingredientsService;
    }
}
