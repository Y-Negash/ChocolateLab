package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estates")
public class EstateController {

    @Autowired
    EstateService estateService;

    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates(){
        List<Estate> estates = estateService.getAllEstates();
        return new ResponseEntity<>(estates, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Estate>> getEstateById(@PathVariable long id){
        Optional<Estate> estate = estateService.getEstateById(id);
        if(estate.isEmpty()){
            Estate estate1 = new Estate();
            return new ResponseEntity<>(estate,HttpStatus.NOT_FOUND);
        } else {
            Estate estate1 = new Estate();
            return new ResponseEntity<>(estate,HttpStatus.OK);
        }
    }

    @PostMapping("/newEstate")
    public ResponseEntity<Estate> addEstate(@RequestBody Estate estate){
       Estate newEstate = estateService.addNewEstate(estate);
       return new ResponseEntity<>(newEstate,HttpStatus.CREATED);
    }
}
