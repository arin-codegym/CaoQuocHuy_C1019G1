package com.codegym.controllers;

import com.codegym.models.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("counter1")
public class CounterController {

    /* add MyCounter in model attribute */
    @ModelAttribute("counter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("counter") MyCounter myCounter, HttpSession session) {

        session.setAttribute("counter1", myCounter);
        ((MyCounter)session.getAttribute("counter1")).increment();
        return "index";
    }
}
