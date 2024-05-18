package com.example.k_dish.web;

import com.example.k_dish.model.entity.Cook;
import com.example.k_dish.service.CookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cook")
public class CookController extends AbstractController<Cook> {
    @Autowired
    private final CookService cookService;

    @Autowired
    public CookController(CookService cookService) {
        this.cookService = cookService;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Cook>> getCooksByName(@PathVariable String name) {
        List<Cook> cooks = cookService.readByName(name);
        if (cooks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cooks, headers, HttpStatus.OK);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<List<Cook>> getCooksByPhone(@PathVariable int phone) {
        List<Cook> cooks = cookService.readByPhone(phone);
        if (cooks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cooks, headers, HttpStatus.OK);
    }

    @Override
    public CookService getService() {
        return cookService;
    }
}
