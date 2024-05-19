package com.example.k_dish.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cook")
@AttributeOverride(name = "id", column = @Column(name = "`ck_id`"))
@Getter @Setter @ToString
@Data
@EqualsAndHashCode(callSuper = false)
public class Cook extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private int phone;
}
