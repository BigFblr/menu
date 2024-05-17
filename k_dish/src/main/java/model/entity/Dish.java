package model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "dish")
@Data
@EqualsAndHashCode(callSuper = false)
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

    @ManyToOne
    @JoinColumn(name = "id_ingredients", referencedColumnName = "id")
    private Ingredients ingredients;
}
