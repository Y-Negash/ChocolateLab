package com.bnta.chocolate.components;

import com.bnta.chocolate.ChocolateApplication;
import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        Estate estate1 = new Estate("Belmont", "France");
        Estate estate2 = new Estate("Cocoa", "St Lucia");
        Estate estate3 = new Estate("Grenada", "Greece");
        Estate estate4 = new Estate("Victoria", "Ghana");
        Estate estate5 = new Estate("Stollmeyer", "Brazil");

        Chocolate choco1 = new Chocolate("FairTrade",70, estate1);
        Chocolate choco2 = new Chocolate("Galaxy", 90, estate2);
        Chocolate choco3 = new Chocolate("Cadbury", 40,estate3);

        estateService.saveEstate(estate1);
        estateService.saveEstate(estate2);
        estateService.saveEstate(estate3);
        estateService.saveEstate(estate4);
        estateService.saveEstate(estate5);

        chocolateService.saveChocolate(choco1);
        chocolateService.saveChocolate(choco2);
        chocolateService.saveChocolate(choco3);

    }
}
