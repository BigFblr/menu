package com.example.k_dish.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Set;

@Getter
@Setter
public class MenuDto {
    private Integer id;
    private String name;
    private Time timeOfAction;
}
