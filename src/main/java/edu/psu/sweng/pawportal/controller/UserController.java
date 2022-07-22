package edu.psu.sweng.pawportal.controller;

import edu.psu.sweng.pawportal.models.Customer;
import edu.psu.sweng.pawportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    public CustomerRepository repo;

    @RequestMapping ( "/homepage")
    public String homePage(){
        return "homepage";
    }
    @RequestMapping ( "/landing")
    public String landingPage(){
        return "landing";
    }
    @RequestMapping ( "/contact_us")
    public String contactPage(){
        return "contact_us";
    }
    @GetMapping( "/register")
    public String CreateNewUser(Model model){
        model.addAttribute("Customer", new Customer());
        return "CustomerRegistration";
    }

    @PostMapping("/registration_processed")
    public String processRegistration(Customer customer){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        repo.save(customer);
        return "RegistrationSuccessful";
    }
}
