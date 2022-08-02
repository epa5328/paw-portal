package edu.psu.sweng.pawportal.controller;

import edu.psu.sweng.pawportal.models.Dog;
import org.springframework.stereotype.Controller;
import edu.psu.sweng.pawportal.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
Comment by Kien: fix up the mappings for the methods below
 */
@Controller
public class DogController {
    @Autowired
    public DogRepository repo;

    // show dog
    @GetMapping("/account/{userID}/dog/{dogID}")
    public String showDog(Dog dog) {
        // SQL query: grab dog info given ID of customer
        return "dogInfoPage";
    }

    // create dog
    @GetMapping("/account/{userID}/dog/new")
    public String createDog(Dog dog) {
        // no dog attributes to inject
        return "newDogPage";
    }
    
    // edit dog
    @GetMapping("/account/{userID}/dog/{dogID}/edit")
    public String editDog(Dog dog) {
        // inject specified dog into HTML
        return "editDogPage";
    }

    // update dog (new/edit)
    @PostMapping("/account/{userID}/dog/{dogID}")
    public String updateDog(Dog dog) {
        // take parameters and save dog
        repo.save(dog);
        // SQL query: grab dog info given ID of customer
        return "dogInfoPage";
    }
}
