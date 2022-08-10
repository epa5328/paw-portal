package edu.psu.sweng.pawportal.controller;

import org.springframework.ui.Model;
import edu.psu.sweng.pawportal.models.CustomerUserDetails;
import org.springframework.stereotype.Controller;
import edu.psu.sweng.pawportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    /*
     * need to duplicate customer repo here
     * in order to populate navbar links
     */
    @Autowired
    public CustomerRepository repo;

    @GetMapping("/")
    public String indexPage(Model model) {
        long loggedIn = CustomerUserDetails.getLoggedIn();
        if (loggedIn != 0) {
            model.addAttribute("customer", repo.findById(loggedIn));
        }
        return "index/index";
    }
    @GetMapping("/contact_us")
    public String contactPage(Model model) {
        long loggedIn = CustomerUserDetails.getLoggedIn();
        if (loggedIn != 0) {
            model.addAttribute("customer", repo.findById(loggedIn));
        }
        return "index/contact_us";
    }
}
