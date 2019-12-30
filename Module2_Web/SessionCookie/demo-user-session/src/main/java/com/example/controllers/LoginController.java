package com.example.controllers;

import com.example.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user1")
public class LoginController {
    /*
     * Add user in model attribute
     */
    @ModelAttribute("user1")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user1") User huy, Model model) {
        System.out.println(huy.getEmail());
        // Implement your business logic
        if (huy.getEmail().equals("admin@gmail.com") && huy.getPassword().equals("123")) {
            // Set user dummy data
            huy.setFname("Sunil");
            System.out.println(huy.getFname());
            huy.setMname("Singh");
            System.out.println(huy.getMname());
            huy.setLname("Bora");
            System.out.println(huy.getLname());
            huy.setAge(28);
            System.out.println(huy.getAge());
        } else {
            model.addAttribute("message", "Login failed. Try again.");
            return "index";
        }
        return "success";
    }

}
