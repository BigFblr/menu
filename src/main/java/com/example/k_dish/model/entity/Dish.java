package com.example.k_dish.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "dish")
@AttributeOverride(name = "id", column = @Column(name = "`dh_id`"))
@Getter
@Setter
@ToString
public class Dish extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private float cost;

    @ManyToOne
    @JoinColumn(name = "id_menu", referencedColumnName = "id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_special_offer", referencedColumnName = "id")
    private SpecialOffer specialOffer;

    @ManyToMany()
    @JoinTable(
            name = "dish_ingredients",
            joinColumns = @JoinColumn(name = "dh_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id")
    )
    private Set<Ingredients> ingredients = new HashSet<>();

    @ManyToMany()
    @JoinTable(
            name = "dish_cook",
            joinColumns = @JoinColumn(name = "dh_id"),
            inverseJoinColumns = @JoinColumn(name = "cook_id")
    )
    private Set<Cook> dhCooks = new HashSet<>();
}
