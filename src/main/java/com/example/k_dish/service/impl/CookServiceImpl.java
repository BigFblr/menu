package com.example.k_dish.service.impl;

import com.example.k_dish.model.entity.Cook;
import com.example.k_dish.repositories.CookRepository;
import com.example.k_dish.service.CookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookServiceImpl implements CookService {
    @Autowired
    private CookRepository cookRepository;

    @Override
    public Cook read(Long id) {
        return cookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cook> read() {
        return cookRepository.findAll();
    }

    @Override
    public void save(Cook cook) {
        cookRepository.save(cook);
    }

    @Override
    public void delete(Long id) {
        cookRepository.deleteById(id);
    }

    @Override
    public List<Cook> readByName(String name) {
        return cookRepository.findByName(name);
    }

    @Override
    public List<Cook> readByPhone(int phone) {
        return cookRepository.findByPhone(phone);
    }
}
