package com.example.k_dish.model.repositories;

import com.example.k_dish.model.entity.SpecialOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SpecialOfferRepository extends JpaRepository<SpecialOffer, Long> {
    List<SpecialOffer> findByName(String name);

    List<SpecialOffer> findByDateOfAction(Date date);

    List<SpecialOffer> findByDateOfActionBefore(Date date);

    List<SpecialOffer> findByDateOfActionAfter(Date date);
}
