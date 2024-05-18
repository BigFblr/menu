package com.example.k_dish.service;

import com.example.k_dish.model.entity.Cook;
import java.util.List;

public interface CookService extends Service<Cook> {
    List<Cook> readByName(String name);
    List<Cook> readByPhone(int phone);
}
