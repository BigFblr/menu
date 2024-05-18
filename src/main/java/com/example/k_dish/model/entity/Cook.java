package com.example.k_dish.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cook")
@Data
@EqualsAndHashCode(callSuper = false)
public class Cook extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private int phone;
}
