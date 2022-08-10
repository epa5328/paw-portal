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

    // show customer
    @GetMapping("/account/{userID}")
    public String showCustomer(Model model, @PathVariable("userID") long userID) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        model.addAttribute("customer", repo.findById(userID));
        return "customer/account";
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

    // update customer
    @PostMapping("/account/{userID}")
    public String updateCustomer(Model model, @PathVariable("userID") long userID, Customer customer) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        repo.findById(userID).propagateChanges(customer); // copy in fields
        repo.save(repo.findById(userID)); // save the changes
        model.addAttribute("customer", repo.findById(userID));
        return "customer/account";
    }

    // delete customer
    @PostMapping("/account/{userID}/delete") // doesn't work with delete method
    public String deleteCustomer(Model model, @PathVariable("userID") long userID) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        repo.delete(repo.findById(userID));
        CustomerUserDetails.setLoggedIn(0);
        return "redirect:/";
    }

    // delete user session
    @PostMapping("/account/{userID}/signout")
    public String deleteUserSession(Model model, @PathVariable("userID") long userID) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        CustomerUserDetails.setLoggedIn(0);
        return "redirect:/";
    }

    // show appointments
    @GetMapping("/account/{userID}/appointment")
    public String appointment(Model model, @PathVariable("userID") long userID) {
        if (CustomerUserDetails.getLoggedIn() != userID) {
            return "redirect:/";
        }
        return "customer/appointment";
    }
}
