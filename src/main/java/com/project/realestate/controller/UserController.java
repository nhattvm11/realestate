package com.project.realestate.controller;

import com.project.realestate.entity.User;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller("/api/v1/protected")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public ModelAndView showProfile(@PathVariable("id") String id) throws UserNotFoundException {
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    @GetMapping("/users/{id}/edit")
    public ModelAndView showEditProfileForm(@PathVariable("id") String id) throws UserNotFoundException {
        User user = userService.getUserById(id);
        return new ModelAndView("edit-profile", "user", user);
    }

    @PostMapping("/users/edit")
    public String editProfile(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if(result.hasErrors())
            return "/user/" + user.getId() + "/edit";
        userService.saveUser(user);
        return "/users/" + user.getId();
    }
}
