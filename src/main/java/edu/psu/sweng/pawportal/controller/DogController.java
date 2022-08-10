package edu.psu.sweng.pawportal.controller;

import edu.psu.sweng.pawportal.models.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import edu.psu.sweng.pawportal.models.CustomerUserDetails;
import edu.psu.sweng.pawportal.repository.CustomerRepository;
import edu.psu.sweng.pawportal.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DogController {
    @Autowired
    public DogRepository repo;
    @Autowired
    public CustomerRepository custRepo;

    // show dogs
    @GetMapping("/account/{userID}/paws")
    public String showDogs(Model model, @PathVariable("userID") long userID) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        model.addAttribute("customer", custRepo.findById(userID));
        model.addAttribute("dogs", repo.findByOwnerId(userID));
        return "dog/allMyPaws";
    }

    // show dog
    @GetMapping("/account/{userID}/dog/{dogID}")
    public String showDog(Model model, @PathVariable("userID") long userID, @PathVariable("dogID") long dogID) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        model.addAttribute("customer", custRepo.findById(userID));
        model.addAttribute("dog", repo.findById(userID));
        return "dogInfoPage";
    }

    // create dog
    @GetMapping("/account/{userID}/dog/new")
    public String createDog(Model model, @PathVariable("userID") long userID, Dog dog) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        model.addAttribute("customer", custRepo.findById(userID));
        return "dog/addNewDog";
    }

    // add dog
    @PostMapping("/account/{userID}/dog/new")
    public String addDog(Model model, @PathVariable("userID") long userID, Dog dog) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        dog.setOwnerId(userID);
        repo.save(dog);
        return "dog/allMyPaws";
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
