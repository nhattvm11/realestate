package com.project.realestate.controller;

import com.project.realestate.entity.Contact;
import com.project.realestate.entity.User;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.model.ContactTemp;
import com.project.realestate.model.PasswordReset;
import com.project.realestate.model.RegisterTemp;
import com.project.realestate.model.UserUpdate;
import com.project.realestate.service.ContactService;
import com.project.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ContactService contactService;

    @GetMapping("/users/{id}")
    public ModelAndView showProfile(@PathVariable("id") String id, HttpServletRequest request) throws UserNotFoundException {
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("profile");
        System.out.println(request.getCookies().toString());
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
    public String editProfile(@Valid @ModelAttribute("user") UserUpdate user,BindingResult result) {
        if(result.hasErrors())
            return "/user/" + user.getId() + "/edit";
        userService.updateUser(user);
        return "redirect:/users/" + user.getId();
    }

    @GetMapping("/users/contacts")
    public String showListContact(Model model) throws UserNotFoundException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        User user = userService.getUSerByEmail(userDetails.getUsername());
        List<Contact> contacts =  contactService.getContactByUserByUserId(user);
        model.addAttribute("contacts", contacts);
        return "listContact";
    }

    @GetMapping("/users/contact/create")
    public ModelAndView createContact(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createContact");
        modelAndView.addObject("contact", new ContactTemp());
        return modelAndView;
    }

    @PostMapping("/users/contact/create")
    public String handleCreateContact(@ModelAttribute ContactTemp contactTemp){
        contactService.saveContact(contactService.parseContactModelToEntity(null, contactTemp));
        return "redirect:/users/contacts";
    }

    @GetMapping("/users/contact/update/{contactId}")
    public ModelAndView showEditContact(@PathVariable("contactId") String id) throws UserNotFoundException {
        ModelAndView model = new ModelAndView();
        model.setViewName("updateContact");
        Contact contact = contactService.findById(id);
        model.addObject("contact", contact);
        return model;
    }

    @PostMapping("/users/contact/update/{contactId}")
    public String handleUpdateContact(@PathVariable("contactId") String id, @ModelAttribute ContactTemp contactTemp){
        contactService.saveContact(contactService.parseContactModelToEntity(id, contactTemp));
        return "redirect:/users/contacts";
    }

    @GetMapping("/password")
    public ModelAndView showFormNewPass() {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("------------" + userDetails.getUsername());
        System.out.println("------------" + userDetails.getPassword());
        ModelAndView modelAndView = new ModelAndView("changePass");
        PasswordReset pass = new PasswordReset();
        pass.setPassword(userDetails.getPassword());
        modelAndView.addObject("pass", pass);
        return new ModelAndView("changePass");
    }

    @PostMapping("/password")
    public String changePassword(@ModelAttribute("pass") @Valid PasswordReset passwordReset, BindingResult result) {
        if(result.hasErrors()) {
            return "password";
        }
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUserByEmail(userDetails.getUsername());
        user.setPassword(passwordReset.getPassword());
        userService.saveUser(user);
        return "redirect:/login";
    }
}
