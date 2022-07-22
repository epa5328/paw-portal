package edu.psu.sweng.pawportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @RequestMapping("/employeeMainPage")
    public String employeeMainPage () {
        return "employeeMainPage";
    }
}
