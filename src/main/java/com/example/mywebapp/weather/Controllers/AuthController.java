package com.example.mywebapp.weather.Controllers;


import com.example.mywebapp.weather.service.DatabaseRepo;
import com.example.mywebapp.weather.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller

public class AuthController {

    private final DatabaseRepo databaseRepo;
    private final UserService userService;

    public AuthController(DatabaseRepo databaseRepo, UserService userService) {
        this.databaseRepo = databaseRepo;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() { return "login"; }

    @PostMapping("/auth")
    public String authenticate(@RequestParam String login, @RequestParam String password, Model model) throws SQLException {

        if (userService.authoriseUser(login, password)) {
            model.addAttribute("message", "Logowanie udane!");
            model.addAttribute("success", true);
            return "postLogin";
        } else {
            model.addAttribute("message", "Błędny login lub hasło.");
            return "login";
        }


//        if(userService.checkIfExists(login)) {
//            model.addAttribute("message", "Błędny login lub hasło.");
//            return "login";
//        }
//        User tempUser = databaseRepo.select(login);
//        boolean ok = tempUser.getUsername().equals(login) && tempUser.getPassword().equals(password);
//
//        if (ok) {
//            model.addAttribute("message", "Logowanie udane!");
//            model.addAttribute("success", true);
//
//        } else {
//            model.addAttribute("message", "Błędny login lub hasło.");
//            return "login";
//        }
    }
}

