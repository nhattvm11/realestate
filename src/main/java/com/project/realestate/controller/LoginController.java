package com.project.realestate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/public")
public class LoginController {

    @GetMapping("/login")
    public String getLogin() {

        System.out.println("cui bap");
        return "login";
    }



}
