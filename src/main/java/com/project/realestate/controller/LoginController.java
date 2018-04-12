package com.project.realestate.controller;

import com.project.realestate.entity.User;
import com.project.realestate.exception.ConfirmationException;
import com.project.realestate.exception.TokenInvalidException;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.exception.UsernameExistException;
import com.project.realestate.model.RegisterTemp;
import com.project.realestate.model.ResetUser;
import com.project.realestate.service.EmailService;
import com.project.realestate.service.JwtTokenService;
import com.project.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/public")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    JwtTokenService jwtTokenService;

    @Autowired
    EmailService emailService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @PostMapping("/login")
//    public String handleLogin() {
//        System.out.println("begin handle login ......");
//        return "login";
//    }

    @GetMapping("/reset")
    public String showFormReset() {
        return "resetForm";
    }

    @PostMapping("/reset")
    public String handleFormReset(@RequestBody ResetUser resetUser) throws UserNotFoundException {
        User user = userService.getUSerByEmail(resetUser.getEmail());
        emailService.sendMailResetPassword(user);
        return "newPass";
    }



    @GetMapping("/newpass")
    public ModelAndView showFormNewPass(@RequestParam String token) throws TokenInvalidException, UsernameExistException, ConfirmationException, UserNotFoundException {
        User user = getUserFormToken(token);
        RegisterTemp userTemp = new RegisterTemp();
        userTemp.setUsername(user.getUsername());
        return new ModelAndView("register", "user", userTemp);
    }

    @PostMapping("/newpass")
    public String resetPass(@Valid @ModelAttribute("user") RegisterTemp userTemp, BindingResult result) throws TokenInvalidException, UsernameExistException, ConfirmationException, UserNotFoundException {
        User user = new User();
        user.setUsername(userTemp.getUsername());
        user.setPassword(user.getPassword());
        userService.saveUser(user);
        return "login";
    }

    private User getUserFormToken(String token) throws TokenInvalidException, UsernameExistException, ConfirmationException, UserNotFoundException {
        String userId = jwtTokenService.verifyToken(token);
        User user = userService.getUserById(userId);
        return user;
    }

}
