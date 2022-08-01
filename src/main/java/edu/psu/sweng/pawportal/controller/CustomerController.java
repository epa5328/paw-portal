package edu.psu.sweng.pawportal.controller;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.psu.sweng.pawportal.models.*;

@Controller
public class CustomerController {
    @RequestMapping("/customerMainPage")
    public String customerMainPage () {
        return "customerMainPage";
    }

    @RequestMapping("/account/{id}")
    public String customerAccount (Model model, @PathVariable Long id) {
        Customer tempCust = new Customer("Joe", "Smith", "555-555-1212", "personal@email.com", "123 Main Street", "passw0rd1", new HashSet<Dog>());
        model.addAttribute("customer", tempCust);
        //model.addAttribute("customer", Customer.getCustomer(id));
        return "accounttemp";
    }
}
