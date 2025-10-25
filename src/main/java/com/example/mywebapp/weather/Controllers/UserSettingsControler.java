package com.example.mywebapp.weather.Controllers;

import com.example.mywebapp.weather.forms.ChangePasswordForm;
import com.example.mywebapp.weather.service.DatabaseRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class UserSettingsControler {

    DatabaseRepo repo;

    public UserSettingsControler(DatabaseRepo repo){
        this.repo=repo;
    }

    @GetMapping("/userSettings/changePassword")
    public String showChangePasswordForm(Model model) {
        model.addAttribute("changePasswordForm", new ChangePasswordForm());


        return "changePassword";
    }

    @PostMapping("/userSettings/changePassword")
    public String handlePasswordChange(@ModelAttribute ChangePasswordForm form, Model model) {
        model.addAttribute("success", "Hasło zostało zmienione.");
        return "changePassword";
    }



    @GetMapping("/userSettings")
    public String userSettings() { return "userSettings"; }

    @GetMapping("/createUser")
    public String createUser() { return "createUser";}

    @GetMapping("/destroyUser")
    public String destroyUser() { return "destroyUser";}

    @GetMapping("/changePassword")
    public String changePassword() { return "changePassword";}
}
