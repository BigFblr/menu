package model.repositories;

import model.entity.SpecialOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SpecialOfferRepository extends JpaRepository<SpecialOffer, Integer> {
    List<SpecialOffer> findByName(String name);

    // Найти предложения, действующие на определенную дату
    List<SpecialOffer> findByDateOfAction(Date date);

    // Найти предложения, действующие до определенной даты
    List<SpecialOffer> findByDateOfActionBefore(Date date);

    // Найти предложения, действующие после определенной даты
    List<SpecialOffer> findByDateOfActionAfter(Date date);
}
