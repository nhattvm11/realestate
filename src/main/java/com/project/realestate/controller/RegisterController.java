package com.project.realestate.controller;

import com.project.realestate.entity.User;
import com.project.realestate.exception.ConfirmationException;
import com.project.realestate.exception.TokenInvalidException;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.exception.UsernameExistException;
import com.project.realestate.model.RegisterTemp;
import com.project.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/public")
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
        return "checkMail";
    }

    @GetMapping("/confirm")
    public String emailConfirm(@RequestParam String token) throws TokenInvalidException, UsernameExistException, ConfirmationException, UserNotFoundException {
        userService.confirmRegistration(token);
        return "redirect:/login";
    }


}
