package com.example.k_dish.service.impl;

import com.example.k_dish.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.k_dish.model.entity.enums.RoleEnum;
import com.example.k_dish.model.entity.User;
import com.example.k_dish.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public void save(User user) {
        repository.save(user);
    }
    public User create(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }
        return repository.saveAndFlush(user);
    }
    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }
    @Override
    public List<User> read() {
        return repository.findAll();
    }
    public User read(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    @Deprecated
    public void getAdmin() {
        var user = getCurrentUser();
        user.setRole(RoleEnum.ROLE_ADMIN);
        save(user);
    }
}
