package com.example.controllers;

import com.example.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/user")
public class UserController {
    /*
     * Get user from session attribute
     */
    @GetMapping("/info")
    public String userInfo(@SessionAttribute("user1") User user, Model model) {
        model.addAttribute("user", user);

        System.out.println("Email: " + user.getEmail());
        System.out.println("First Name: " + user.getFname());
        return "user";
    }
}
