package com.example.k_dish.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingredients")
@AttributeOverride(name = "id", column = @Column(name = "`ig_id`"))
@Getter
@Setter
@ToString
public class Ingredients extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private String quantity;

}
