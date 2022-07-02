package edu.psu.sweng.pawportal.controller;

import edu.psu.sweng.pawportal.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @RequestMapping ( "/homepage")
    public String homePage(){
        return "homepage.html";
    }
    @GetMapping( "/Register")
    public String CreateNewUser(Model model){
        model.addAttribute("Customer", new Customer());
        return "CustomerRegistration.html";
    }
}
