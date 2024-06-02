package com.example.k_dish.web;

import com.example.k_dish.model.entity.Dish;
import com.example.k_dish.model.entity.Menu;
import com.example.k_dish.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController extends AbstractController<Menu> {
    @Autowired
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Menu>> getMenusByName(@PathVariable String name) {
        List<Menu> menus = menuService.readByName(name);
        if (menus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(menus, headers, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> createMemu(@RequestBody Menu menu) {
        try {
            menuService.save(menu);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public MenuService getService() {
        return menuService;
    }
}
