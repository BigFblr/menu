package com.example.k_dish.service;

import com.example.k_dish.model.entity.Menu;
import java.util.List;

public interface MenuService extends Service<Menu> {
    List<Menu> readByName(String name);
}
