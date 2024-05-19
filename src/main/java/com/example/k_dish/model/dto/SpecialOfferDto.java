package com.example.k_dish.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class SpecialOfferDto {
    private Integer id;
    private String name;
    private Date dateOfAction;
    private Set<DishDto> soDishes;
}
