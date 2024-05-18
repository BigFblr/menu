package com.example.k_dish.service;

import com.example.k_dish.model.entity.SpecialOffer;
import java.util.Date;
import java.util.List;

public interface SpecialOfferService extends Service<SpecialOffer> {
    List<SpecialOffer> readByName(String name);
    List<SpecialOffer> readByDateOfAction(Date date);
    List<SpecialOffer> readByDateOfActionBefore(Date date);
    List<SpecialOffer> readByDateOfActionAfter(Date date);
}
