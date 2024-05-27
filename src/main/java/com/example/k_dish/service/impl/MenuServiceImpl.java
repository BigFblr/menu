package com.example.k_dish.service.impl;

import com.example.k_dish.model.entity.Menu;
import com.example.k_dish.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.k_dish.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu read(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public List<Menu> read() {
        return menuRepository.findAll();
    }

    @Override
    public void save(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public List<Menu> readByName(String name) {
        return menuRepository.findByName(name);
    }
}