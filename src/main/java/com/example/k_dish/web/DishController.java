package com.example.k_dish.web;

import com.example.k_dish.model.entity.Cook;
import com.example.k_dish.model.entity.Dish;
import com.example.k_dish.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController extends AbstractController<Dish> {
    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Dish>> getDishesByName(@PathVariable String name) {
        List<Dish> dishes = dishService.readByName(name);
        if (dishes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dishes, headers, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/cost/{cost}")
    public ResponseEntity<List<Dish>> getDishesByCost(@PathVariable float cost) {
        List<Dish> dishes = dishService.readByCost(cost);
        if (dishes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        double discountPercentage = 10.0;
        for (Dish dish : dishes) {
            double discountedPrice = dish.getCost() * (1 - discountPercentage / 100);
            dish.setCost((float) discountedPrice);
        }

        return new ResponseEntity<>(dishes, headers, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> createDish(@RequestBody Dish dish) {
        try {
            dishService.save(dish);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public DishService getService() {
        return dishService;
    }
}
