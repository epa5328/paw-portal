package edu.psu.sweng.pawportal.controller;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.psu.sweng.pawportal.models.*;

@Controller
public class CustomerController {
    @RequestMapping("/customerMainPage")
    public String customerMainPage () {
        return "customerMainPage";
    }

    @RequestMapping("/account/{userID}")
    public String customerAccount (Model model) {
        Customer tempCust = new Customer("Joe", "Smith", "555-555-1212", "personal@email.com", "123 Main Street", "passw0rd1", new HashSet<Dog>());
        model.addAttribute("customer", tempCust);
        return "accounttemp";
    }
}
