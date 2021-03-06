package com.project.realestate.controller;


import com.project.realestate.entity.User;
import com.project.realestate.exception.UserNotFoundException;
import com.project.realestate.helper.TokenHelper;
import com.project.realestate.service.CustomUserDetailService;
import com.project.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProtectedLoginController {

    private static final String TOKEN = "token";
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenHelper tokenHelper;

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) throws UserNotFoundException {
        System.out.println("begin handle login with username is " + username + " and pass word : " + password + "......");
        UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {

        }
        String token = tokenHelper.generateToken(username);
        Cookie cookie = new Cookie(TOKEN, token);
        response.addCookie(cookie);
        //User user =  userService.getUSerByEmail(username);
        return "redirect:/home";
    }
}
