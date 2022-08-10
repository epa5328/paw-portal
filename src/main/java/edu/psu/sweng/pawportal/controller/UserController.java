package edu.psu.sweng.pawportal.controller;

//import org.springframework.ui.Model;
import edu.psu.sweng.pawportal.models.Customer;
import edu.psu.sweng.pawportal.models.CustomerUserDetails;
import org.springframework.stereotype.Controller;
import edu.psu.sweng.pawportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class UserController {

    @Autowired
    public CustomerRepository repo;

    @GetMapping("/signup")
    public String signUpPage(Customer customer) {
        return "customer/signup";
    }

    @PostMapping("/registration_processed")
    public String processRegistration(Customer customer){
        if (repo.findByEmail(customer.getEmail()) != null) {
            return "customer/RegistrationUnsuccessful";
        }
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
        Customer accountCust = repo.findByEmail(customer.getEmail());
        if (encoder.matches(customer.getPassword(), accountCust.getPassword())) {
            CustomerUserDetails.setLoggedIn(accountCust.getId());
            return "redirect:/account/" + accountCust.getId();
        }
        return "redirect:/"; // FAIL!
    }
}
