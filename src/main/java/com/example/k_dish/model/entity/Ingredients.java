package com.example.k_dish.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "ingredients")
@Data
@EqualsAndHashCode(callSuper = false)
public class Ingredients extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private String quantity;

}
