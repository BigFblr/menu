package com.example.k_dish.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import java.util.Date;

@Entity
@Table(name = "special_offer")
@Getter @Setter @ToString
public class SpecialOffer extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_action")
    private Date dateOfAction;

    @ManyToMany()
    @JoinTable(
            name = "special_offer_dish",
            joinColumns = @JoinColumn(name = "id_special_offer"),
            inverseJoinColumns = @JoinColumn(name = "id_dish")
    )
    private Set<Dish> soDishes = new HashSet<>();
}
