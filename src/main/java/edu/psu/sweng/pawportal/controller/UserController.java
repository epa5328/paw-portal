package edu.psu.sweng.pawportal.controller;

import edu.psu.sweng.pawportal.models.Customer;
import edu.psu.sweng.pawportal.models.CustomerUserDetails;
import edu.psu.sweng.pawportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    public CustomerRepository repo;

    @RequestMapping ("/signup")
    public String signUpPage(Customer customer) {
        return "customer/signup";
    }

    @PostMapping("/registration_processed")
    public String processRegistration(Customer customer){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(customer.getPassword());
        // customer object comes over with cleartext
        customer.setPassword(encodedPassword);
        repo.save(customer);
        CustomerUserDetails.setLoggedIn(customer.getId());
        return "customer/RegistrationSuccessful";
    }

    @PostMapping("/login")
    public String processLogin(Customer customer) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(customer.getPassword());
        Customer accountCust = repo.findByEmail(customer.getEmail());
        if (encodedPassword.equals(accountCust.getPassword())) {
            CustomerUserDetails.setLoggedIn(accountCust.getId());
            return "redirect:/account/" + accountCust.getId();
        }
        return "redirect:/"; // FAIL!
    }
}
