package com.example.k_dish.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class DishDto {
    private Integer id;
    private String name;
    private float cost;
    private Set<IngredientsDto> ingredients;
}
