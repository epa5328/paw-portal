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
    @RequestMapping ( "/account")
    public String accountPage(){
        return "account";
    }
    @RequestMapping ( "/appointment")
    public String appointmentPage(){
        return "appointment";
    }
    @RequestMapping ( "/paws")
    public String pawsPage(){
        return "paws";
    }
    @RequestMapping ( "/signup")
    public String signUpPage(){
        return "signup";
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
    /*
    @PostMapping("/login") // method is written in pseudocode style; modify into proper Java code later
    public String GetEmail(User user) {
        // use SQL query to grab user.type given inputted email
        if (user.type == 0) {// 0 = customer
            return "redirect: /customerMainPage";
        } else if (user.type == 1) {
            return "redirect: /employeeMainPage";
        }
        return "redirect: /emailNotExist";
    }
     */
}
