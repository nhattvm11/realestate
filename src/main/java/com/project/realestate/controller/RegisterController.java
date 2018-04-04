package com.project.realestate.controller;

import com.project.realestate.entity.User;
import com.project.realestate.model.RegisterTemp;
import com.project.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView getRegister() {
        return new ModelAndView("register", "user", new RegisterTemp());
    }

    @PostMapping("/register")
    public String handleRegister(@Valid @ModelAttribute("user") RegisterTemp registerTemp, BindingResult result) {
        if(result.hasErrors()) {
            return "register";
        }
        User user = new User(registerTemp.getUsername(), registerTemp.getPassword());
        userService.register(user);
        return "confirm";
    }

    @GetMapping("/confirm")
    public String emailConfirm(@RequestParam String token) {
        userService.confirmRegistration(token);
        return "redirect:/login";
    }
}
