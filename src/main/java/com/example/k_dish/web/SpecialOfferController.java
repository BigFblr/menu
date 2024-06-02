package com.example.k_dish.web;

import com.example.k_dish.model.entity.Dish;
import com.example.k_dish.model.entity.SpecialOffer;
import com.example.k_dish.service.SpecialOfferService;
import jdk.jfr.Percentage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/specialOffer")
public class SpecialOfferController extends AbstractController<SpecialOffer> {
    @Autowired
    private final SpecialOfferService specialOfferService;

    @Autowired
    public SpecialOfferController(SpecialOfferService specialOfferService) {
        this.specialOfferService = specialOfferService;
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<SpecialOffer>> getSpecialOffersByName(@PathVariable String name) {
        List<SpecialOffer> specialOffers = specialOfferService.readByName(name);
        if (specialOffers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(specialOffers, headers, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/discount/{discountPercentage}")
    public ResponseEntity<List<SpecialOffer>> getSpecialOffersByDiscount(@PathVariable Double discountPercentage) {
        List<SpecialOffer> specialOffers = specialOfferService.readByDiscountPercentage(discountPercentage);
        if (specialOffers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(specialOffers, headers, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/date/{date}")
    public ResponseEntity<List<SpecialOffer>> getSpecialOffersByDate(@PathVariable Date date) {
        List<SpecialOffer> specialOffers = specialOfferService.readByDateOfAction(date);
        if (specialOffers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(specialOffers, headers, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> createSpecialOfferController(@RequestBody SpecialOffer specialOffer) {
        try {
            specialOfferService.save(specialOffer);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public SpecialOfferService getService() {
        return specialOfferService;
    }
}
