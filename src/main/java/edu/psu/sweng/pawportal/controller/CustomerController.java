package edu.psu.sweng.pawportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    @RequestMapping("/customerMainPage")
    public String customerMainPage () {
        return "customerMainPage";
    }
}
