package edu.psu.sweng.pawportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    @RequestMapping ("/homepage")
    public String homePage(){
        return "homepage.html";
    }
}
