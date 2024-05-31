package com.example.k_dish.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "dish")
@Getter @Setter @ToString
public class Dish extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private double cost;

    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_special_offer", nullable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private SpecialOffer specialOffer;

    @ManyToMany()
    @JoinTable(
            name = "dish_ingredients",
            joinColumns = @JoinColumn(name = "id_dish"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredients")
    )
    private Set<Ingredients> ingredients = new HashSet<>();

    @ManyToMany()
    @JoinTable(
            name = "dish_cook",
            joinColumns = @JoinColumn(name = "id_dish"),
            inverseJoinColumns = @JoinColumn(name = "id_cook")
    )
    private Set<Cook> dishCooks = new HashSet<>();
}
