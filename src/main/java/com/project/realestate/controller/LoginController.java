package com.project.realestate.controller;

import com.project.realestate.entity.User;
import com.project.realestate.exception.ConfirmationException;
import com.project.realestate.exception.TokenInvalidException;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.exception.UsernameExistException;
import com.project.realestate.model.PasswordReset;
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

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
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

    @RequestMapping(value = "/{pathURL}", method = RequestMethod.POST)
    public String handleFormReset(@ModelAttribute("email") ResetUser resetUser, @PathVariable String pathURL) throws UserNotFoundException {
        User user = userService.getUSerByEmail(resetUser.getEmail());
        emailService.sendMailResetPassword(user);
        return "redirect:/confirm-reset";
    }

    @GetMapping("/confirm-reset")
    public String confirmReset() {
        return "resetConfirm";
    }


    @GetMapping("/newpass")
    public ModelAndView showFormNewPass(@RequestParam String token, HttpServletResponse response) throws TokenInvalidException, UsernameExistException, ConfirmationException, UserNotFoundException {
        User user = getUserFormToken(token);
        RegisterTemp userTemp = new RegisterTemp();
        userTemp.setUsername(user.getUsername());
        response.addCookie(new Cookie("username", userTemp.getUsername()));
        return new ModelAndView("newPass", "user", userTemp);
    }

    @PostMapping("/newpass")
    public String resetPass(@Valid @ModelAttribute("user") PasswordReset passwordReset, BindingResult result, ServletRequest request) throws TokenInvalidException, UsernameExistException, ConfirmationException, UserNotFoundException {
        HttpServletRequest req = (HttpServletRequest) request;
        User user = new User();
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("username"))
                user.setUsername(cookie.getValue());
        }
        User updateUser = userService.getUSerByEmail(user.getUsername());
        if(result.hasErrors()) {
            return "newPass";
        }
        updateUser.setPassword(passwordReset.getPassword());
        userService.saveUser(updateUser);
        return "redirect:/login";
    }

    private User getUserFormToken(String token) throws TokenInvalidException, UsernameExistException, ConfirmationException, UserNotFoundException {
        String userId = jwtTokenService.verifyToken(token);
        User user = userService.getUserById(userId);
        return user;
    }

}
