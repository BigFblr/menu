package com.example.k_dish.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu")
@Getter @Setter @ToString
public class Menu extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "time_of_action")
    private Time timeOfAction;
}


