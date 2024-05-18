package com.example.k_dish.service.impl;

import com.example.k_dish.model.entity.SpecialOffer;
import com.example.k_dish.model.repositories.SpecialOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.k_dish.service.SpecialOfferService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SpecialOfferServiceImpl implements SpecialOfferService {
    @Autowired
    private SpecialOfferRepository specialOfferRepository;

    @Override
    public SpecialOffer read(Integer id) {
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
    public void delete(Integer id) {
        specialOfferRepository.deleteById(id);
    }

    @Override
    public List<SpecialOffer> readByName(String name) {
        return specialOfferRepository.findByName(name);
    }

    @Override
    public List<SpecialOffer> readByDateOfAction(Date date) {
        return specialOfferRepository.findByDateOfAction(date);
    }

    @Override
    public List<SpecialOffer> readByDateOfActionBefore(Date date) {
        return specialOfferRepository.findByDateOfActionBefore(date);
    }

    @Override
    public List<SpecialOffer> readByDateOfActionAfter(Date date) {
        return specialOfferRepository.findByDateOfActionAfter(date);
    }
}
