package model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Time;

@Entity
@Table(name = "menu")
@Data
@EqualsAndHashCode(callSuper = false)
public class Menu extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "time_of_action")
    private Time timeOfAction;
}
