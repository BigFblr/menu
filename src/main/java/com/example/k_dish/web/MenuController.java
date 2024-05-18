package com.example.k_dish.web;

import com.example.k_dish.model.entity.Menu;
import com.example.k_dish.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/menu")
public class MenuController extends AbstractController<Menu> {
    @Autowired
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Menu>> getMenusByName(@PathVariable String name) {
        List<Menu> menus = menuService.readByName(name);
        if (menus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(menus, headers, HttpStatus.OK);
    }

    @Override
    public MenuService getService() {
        return menuService;
    }
}
