package edu.psu.sweng.pawportal.controller;

//import edu.psu.sweng.pawportal.models.Dog;
import edu.psu.sweng.pawportal.models.Customer;
import org.springframework.stereotype.Controller;
import edu.psu.sweng.pawportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    /*
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
    */

    @Autowired
    public CustomerRepository repo;

    // show customer
    @GetMapping("/account/{userID}")
    public String showCustomer(Customer customer) {
        // SQL query: grab customer info given ID
        return "customerInfoPage";
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

// hi it's me