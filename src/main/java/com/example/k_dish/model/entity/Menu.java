package com.example.k_dish.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu")
@AttributeOverride(name = "id", column = @Column(name = "`mn_id`"))
@Getter
@Setter
@ToString
public class Menu extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "time_of_action")
    private Time timeOfAction;

    @ManyToMany()
    @JoinTable(
            name = "menu_dish",
            joinColumns = @JoinColumn(name = "mn_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private Set<Dish> mnDishes = new HashSet<>();
}

