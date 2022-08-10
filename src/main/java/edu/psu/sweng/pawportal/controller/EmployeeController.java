package edu.psu.sweng.pawportal.controller;

//import org.springframework.ui.Model;
import edu.psu.sweng.pawportal.models.Employee;
//import edu.psu.sweng.pawportal.models.EmployeeUserDetails;
import org.springframework.stereotype.Controller;
import edu.psu.sweng.pawportal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    /*
    @RequestMapping("/employeeMainPage")
    public String employeeMainPage () {
        return "employeeMainPage";
    }
    */

    @Autowired
    public EmployeeRepository repo;

    // show employee
    @GetMapping("/walker/{empID}")
    public String showEmployee(Employee employee) {
        // SQL query: grab employee info given ID
        return "employeeInfoPage";
    }

    // create employee
    @GetMapping("/walker/new")
    public String createEmployee(Employee employee) {
        // no employee attributes to inject
        return "newEmployeePage";
    }
    
    // edit employee
    @GetMapping("/walker/{empID}/edit")
    public String editEmployee(Employee employee) {
        // inject specified employee into HTML
        return "editEmployeePage";
    }

    // update employee (new/edit)
    @PostMapping("/walker/{empID}")
    public String updateCustomer(Employee employee) {
        // take parameters and save employee
        repo.save(employee);
        // SQL query: grab employee info given ID
        return "employeeInfoPage";
    }
}
