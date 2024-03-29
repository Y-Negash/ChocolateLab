package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
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

    @PostMapping("/newChocolate")
    public ResponseEntity<Chocolate> addChocolate(@RequestBody ChocolateDTO chocolateDTO){
        Chocolate chocolate = chocolateService.addNewChocolate(chocolateDTO);
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

     @GetMapping("/Percentage")
    public ResponseEntity<List<Chocolate>> getChocolate(@RequestParam int cocoaPercentage){
        List<Chocolate> chocolates;
        if (cocoaPercentage >= 60){
            chocolates = chocolateService.getCocoaPercentage(cocoaPercentage);
            return new ResponseEntity<>(chocolates, HttpStatus.OK);
        } else
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
     }

}
