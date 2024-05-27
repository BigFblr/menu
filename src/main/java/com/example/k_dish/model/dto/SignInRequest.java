package com.example.k_dish.model.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}