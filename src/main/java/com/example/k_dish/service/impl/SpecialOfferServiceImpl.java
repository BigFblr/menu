package com.example.k_dish.service.impl;

import com.example.k_dish.model.entity.SpecialOffer;
import com.example.k_dish.repositories.SpecialOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.k_dish.service.SpecialOfferService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialOfferServiceImpl implements SpecialOfferService {
    @Autowired
    private SpecialOfferRepository specialOfferRepository;

    @Override
    public SpecialOffer read(Long id) {
        return specialOfferRepository.findById(id).orElse(null);
    }

    @Override
    public List<SpecialOffer> read() {
        return specialOfferRepository.findAll();
    }

    @Override
    public void save(SpecialOffer specialOffer) {
        specialOfferRepository.save(specialOffer);
    }

    @Override
    public void delete(Long id) {
        specialOfferRepository.deleteById(id);
    }

    @Override
    public List<SpecialOffer> readByName(String name) {
        return specialOfferRepository.findByName(name);
    }

    @Override
    public List<SpecialOffer> readByDateOfAction(Date date) {
        return specialOfferRepository.findAll()
                .stream()
                .filter(specialOffer -> specialOffer.getDateOfAction().equals(date))
                .collect(Collectors.toList());
    }
    @Override
    public List<SpecialOffer> readByDateOfActionBefore(Date date) {
        return specialOfferRepository.findAll()
                .stream()
                .filter(specialOffer -> specialOffer.getDateOfAction().before(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<SpecialOffer> readByDateOfActionAfter(Date date) {
        return specialOfferRepository.findAll()
                .stream()
                .filter(specialOffer -> specialOffer.getDateOfAction().after(date))
                .collect(Collectors.toList());
    }
    @Override
    public List<SpecialOffer> readByDiscountPercentage(Double discountPercentage) {
        return specialOfferRepository.findByDiscountPercentage(discountPercentage);
    }
}
