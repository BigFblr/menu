package com.example.k_dish.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cook")
@Getter @Setter @ToString
public class Cook extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private int phone;
}
