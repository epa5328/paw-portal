package edu.psu.sweng.pawportal.controller;

import edu.psu.sweng.pawportal.models.Customer;
import edu.psu.sweng.pawportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    public CustomerRepository repo;

    /*
    These account URL variable may need to be deleted. when the account link is clicked from the homepage, it should direct
    the user to the Customer controller pathVariable /account/{id} if authorized.
     */
    @RequestMapping ("/account")
    public String accountPage(){
        return "customer/account";
    }
    @RequestMapping ("/appointment")
    public String appointmentPage(){
        return "customer/appointment";
    }
    @RequestMapping ("/paws")
    public String pawsPage(){
        return "customer/paws";
    }

    /*
    by: Kevin
    The Following 2 controllers are meant to do the same thing.
    The /signup controller will need alterations in order to save the newly registered user to the repo.
     */
    @RequestMapping ("/signup")
    public String signUpPage(Customer customer) {
        return "customer/signup";
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
