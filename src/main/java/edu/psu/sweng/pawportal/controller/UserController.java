package edu.psu.sweng.pawportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    @RequestMapping (value = "/homepage", method = RequestMethod.POST)
    @ResponseBody
    public String homePage(){
        return "homepage";
    }
}
