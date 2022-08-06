package edu.psu.sweng.pawportal.controller;

import org.springframework.ui.Model;
import edu.psu.sweng.pawportal.models.Customer;
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

    // show customer
    @GetMapping("/account/{userID}")
    public String showCustomer(Model model, @PathVariable("userID") long userID) {
        model.addAttribute("customer", repo.findById(userID));
        return "accounttemp";
    }

    // create customer
    @GetMapping("/account/new")
    public String createCustomer(Customer customer) {
        // no customer attributes to inject
        return "newCustomerPage";
    }
    
    // edit customer
    @GetMapping("/account/{userID}/edit")
    public String editCustomer(Customer customer) {
        // inject specified customer into HTML
        return "editCustomerPage";
    }

    // update customer (new/edit)
    @PostMapping("/account/{userID}")
    public String updateCustomer(Customer customer) {
        // take parameters and save customer
        repo.save(customer);
        // SQL query: grab customer info given ID
        return "customerInfoPage";
    }
}
