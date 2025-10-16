package com.example.mywebapp.weather.Controllers;


import com.example.mywebapp.weather.service.DatabaseRepo;
import com.example.mywebapp.weather.service.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller

public class AuthController {

    private final DatabaseRepo databaseRepo;

    public AuthController(DatabaseRepo databaseRepo) {
        this.databaseRepo = databaseRepo;
    }

    @GetMapping("/login")
    public String login() { return "login"; }

    @PostMapping("/auth")
    public String authenticate(@RequestParam String login, @RequestParam String password, Model model) throws SQLException {

        User tempUser = databaseRepo.select(login);

        if(tempUser.isUserNull()) {
            model.addAttribute("message", "Błędny login lub hasło.");
            return "login";
        }
        boolean ok = tempUser.getUsername().equals(login) && tempUser.getPassword().equals(password);

        if (ok) {
            model.addAttribute("message", "Logowanie udane!");
            model.addAttribute("success", true);
            return "postLogin";
        } else {
            model.addAttribute("message", "Błędny login lub hasło.");
            return "login";
        }
    }
}

