package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateService estateService;

    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();
    }

    public Chocolate saveChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }

    public Optional<Chocolate> getChocolateById(long id) {
        return chocolateRepository.findById(id);
    }

    public List<Chocolate> getCocoaPercentage(int cocoaPercentage) {
        return chocolateRepository.findByCocoaPercentageGreaterThanEqual(cocoaPercentage);
    }

//    method returns Chocolate with an estateId
    public Chocolate addNewChocolate(ChocolateDTO chocolateDTO){
        long estateId = chocolateDTO.getEstateId();
        Estate estate = estateService.getEstateById(estateId).get();
        Chocolate chocolate = new Chocolate();
        chocolate.setName(chocolateDTO.getName());
        chocolate.setCocoaPercentage(chocolateDTO.getCocoaPercentage());
        chocolate.setEstate(estate);
        chocolateRepository.save(chocolate);
        return chocolate;
}



}
