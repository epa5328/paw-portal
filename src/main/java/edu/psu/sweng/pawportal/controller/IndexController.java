package edu.psu.sweng.pawportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping ("/")
    public String indexPage() {
        return "index/index";
    }
    @RequestMapping ("/home")
    public String homePage() {
        return "index/index";
    }
    @RequestMapping ("/contact_us")
    public String contactPage() {
        return "index/contact_us";
    }
}
