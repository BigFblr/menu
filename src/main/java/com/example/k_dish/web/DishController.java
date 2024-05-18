package com.example.k_dish.web;

import com.example.k_dish.model.entity.Dish;
import com.example.k_dish.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dish")
public class DishController extends AbstractController<Dish> {
    @Autowired
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

    @GetMapping("/cost/{cost}")
    public ResponseEntity<List<Dish>> getDishesByCost(@PathVariable float cost) {
        List<Dish> dishes = dishService.readByCost(cost);
        if (dishes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dishes, headers, HttpStatus.OK);
    }

    @Override
    public DishService getService() {
        return dishService;
    }
}
