package com.example.k_dish.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import java.util.Date;

@Entity
@Table(name = "special_offer")
@AttributeOverride(name = "id", column = @Column(name = "`so_id`"))
@Getter
@Setter
@ToString
public class SpecialOffer extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_action")
    private Date dateOfAction;

    @ManyToMany()
    @JoinTable(
            name = "special_offer_dish",
            joinColumns = @JoinColumn(name = "so_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private Set<Dish> soDishes = new HashSet<>();
}
