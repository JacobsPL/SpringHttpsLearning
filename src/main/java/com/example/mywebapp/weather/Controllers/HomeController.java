package com.example.mywebapp.weather.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() { return "index"; }

    @GetMapping("/postLogin")
    public String postLogin() {
        return "redirect:/index";
    }
}


