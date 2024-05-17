package model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Entity
@Table(name = "special_offer")
@Data
@EqualsAndHashCode(callSuper = false)
public class SpecialOffer extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_action")
    private Date dateOfAction;

}
