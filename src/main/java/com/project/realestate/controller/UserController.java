package com.project.realestate.controller;

import com.project.realestate.entity.Contact;
import com.project.realestate.entity.User;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.model.UserUpdate;
import com.project.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/public")
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
        UserUpdate userUpdate = new UserUpdate();
        userUpdate.setId(user.getId());
        userUpdate.setUsername(user.getUsername());
        for (Contact contact : user.getContactsById()) {
            if(contact.getMainContact()) {
                userUpdate.setIdContact(contact.getId());
                userUpdate.setAddress(contact.getAddress());
                userUpdate.setEmail(contact.getEmail());
                userUpdate.setPhone(contact.getPhone());
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userUpdate);
        modelAndView.setViewName("editProfile");
        return modelAndView;
    }

    @PostMapping("/users/edit")
    public String editProfile(@Valid @ModelAttribute("user") UserUpdate user, BindingResult result) {
        if(result.hasErrors())
            return "/user/" + user.getId() + "/edit";
        userService.updateUser(user);
        return "/users/" + user.getId();
    }
}
