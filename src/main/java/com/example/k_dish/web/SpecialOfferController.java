package com.example.k_dish.web;

import com.example.k_dish.model.entity.SpecialOffer;
import com.example.k_dish.service.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/specialOffer")
public class SpecialOfferController extends AbstractController<SpecialOffer> {
    @Autowired
    private final SpecialOfferService specialOfferService;

    @Autowired
    public SpecialOfferController(SpecialOfferService specialOfferService) {
        this.specialOfferService = specialOfferService;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<SpecialOffer>> getSpecialOffersByName(@PathVariable String name) {
        List<SpecialOffer> specialOffers = specialOfferService.readByName(name);
        if (specialOffers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(specialOffers, headers, HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<SpecialOffer>> getSpecialOffersByDate(@PathVariable Date date) {
        List<SpecialOffer> specialOffers = specialOfferService.readByDateOfAction(date);
        if (specialOffers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(specialOffers, headers, HttpStatus.OK);
    }

    @Override
    public SpecialOfferService getService() {
        return specialOfferService;
    }
}
