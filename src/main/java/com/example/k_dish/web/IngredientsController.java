package com.example.k_dish.web;

import com.example.k_dish.model.entity.Dish;
import com.example.k_dish.model.entity.Ingredients;
import com.example.k_dish.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController extends AbstractController<Ingredients> {
    @Autowired
    private final IngredientsService ingredientsService;

    @Autowired
    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all")
    public ResponseEntity<List<Ingredients>> getAllIngredients() {
        List<Ingredients> allIngredients = ingredientsService.getAllIngredients();
        if (allIngredients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allIngredients, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Ingredients>> getIngredientsByName(@PathVariable String name) {
        List<Ingredients> ingredients = ingredientsService.readByName(name);
        if (ingredients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ingredients, headers, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> createIngredients(@RequestBody Ingredients ingredients) {
        try {
            ingredientsService.save(ingredients);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{ingredientId}")
    public ResponseEntity<?> updateIngredient(@PathVariable Long ingredientId, @RequestBody Ingredients updatedIngredient) {
        try {
            ingredientsService.update(ingredientId, updatedIngredient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{ingredientId}")
    public ResponseEntity<?> deleteIngredient(@PathVariable Long ingredientId) {
        try {
            ingredientsService.delete(ingredientId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
 @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all/record")
    public ResponseEntity<Long> getRecordIngredients() {
       Long record = ingredientsService.recordIngredients() {
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
}

    @Override
    public IngredientsService getService() {
        return ingredientsService;
    }
}
