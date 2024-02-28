package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(){
        List<Chocolate> chocolate  = chocolateService.getAllChocolates();
        return new ResponseEntity<>(chocolate, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chocolate> newChocolate(@RequestBody Chocolate chocolate){
         chocolateService.saveChocolate(chocolate);
         return new ResponseEntity<>(chocolate, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Chocolate>> getChocolateById(@PathVariable long id){
        Optional<Chocolate> chocolate = chocolateService.getChocolateById(id);
        if(chocolate.isEmpty()){
            Chocolate chocolate1 = new Chocolate();
            return new ResponseEntity<>(chocolate,HttpStatus.NOT_FOUND);
        } else {
            Chocolate chocolate1 = new Chocolate();
            return new ResponseEntity<>(chocolate,HttpStatus.OK);
        }
     }

}
