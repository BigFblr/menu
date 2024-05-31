package com.example.k_dish.web;

import com.example.k_dish.model.entity.Cook;
import com.example.k_dish.model.entity.Dish;
import com.example.k_dish.service.CookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cook")
public class CookController extends AbstractController<Cook> {
    private final CookService cookService;

    @Autowired
    public CookController(CookService cookService) {
        this.cookService = cookService;
    }

@PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Cook>> getCooksByName(@PathVariable String name) {
        List<Cook> cooks = cookService.readByName(name);
        if (cooks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cooks, headers, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/phone/{phone}")
    public ResponseEntity<List<Cook>> getCooksByPhone(@PathVariable int phone) {
        List<Cook> cooks = cookService.readByPhone(phone);
        if (cooks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cooks, headers, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> createCook(@RequestBody Cook cook) {
        try {
            cookService.save(cook);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public CookService getService() {
        return cookService;
    }
}
