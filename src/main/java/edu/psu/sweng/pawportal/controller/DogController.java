package edu.psu.sweng.pawportal.controller;

import edu.psu.sweng.pawportal.models.Dog;
import edu.psu.sweng.pawportal.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
Comment by Kien: fix up the mappings for the methods below
 */
@Controller
public class DogController {
    @Autowired
    public DogRepository repo;

    @GetMapping("/dogInfoPage")
    public String displayDogInfo () {
        // SQL query: grab dog info given ID of customer
        return "dogInfoPage";
    }

    public String addDog (Dog dog) {
        repo.save(dog);
        return "addDogPage";
    }
}
