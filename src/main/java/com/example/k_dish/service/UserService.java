package com.example.k_dish.service;

import com.example.k_dish.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends Service<User>{
    public User getByUsername(String username);
    public UserDetailsService userDetailsService();
    public User getCurrentUser();
}
