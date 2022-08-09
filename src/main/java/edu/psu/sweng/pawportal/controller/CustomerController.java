package edu.psu.sweng.pawportal.controller;

import org.springframework.ui.Model;
import edu.psu.sweng.pawportal.models.Customer;
import edu.psu.sweng.pawportal.models.CustomerUserDetails;

import org.springframework.stereotype.Controller;
import edu.psu.sweng.pawportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    public CustomerRepository repo;

    // no customer
    @GetMapping("/account")
    public String noCustomer() {
        return "redirect:/";
    }
    // some customer
    @GetMapping("/customer")
    public String someCustomer() {
        return noCustomer();
    }

    // customer stuff
    @GetMapping("/customer/{page}")
    public String customerStuff(@PathVariable("page") String page) {
        return "customer/" + page;
    } 

    // show customer
    @GetMapping("/account/{userID}")
    public String showCustomer(Model model, @PathVariable("userID") long userID) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        model.addAttribute("customer", repo.findById(userID));
        return "customer/account";
    }

    // create customer
    @GetMapping("/account/new")
    public String createCustomer(Customer customer) {
        // no customer attributes to inject
        return "newCustomerPage";
    }
    
    // edit customer
    @GetMapping("/account/{userID}/edit")
    public String editCustomer(Model model, @PathVariable("userID") long userID) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        model.addAttribute("customer", repo.findById(userID));
        return "customer/editcust";
    }

    // update customer (new/edit)
    @PostMapping("/account/{userID}")
    public String updateCustomer(Model model, @PathVariable("userID") long userID, Customer customer) {
        if (CustomerUserDetails.getLoggedIn() == 0) {
            return "redirect:/";
        }
        repo.findById(userID).propagateChanges(customer); // copy in fields
        repo.save(repo.findById(userID)); // save the changes
        model.addAttribute("customer", repo.findById(userID));
        return "customer/account";
    }
}
