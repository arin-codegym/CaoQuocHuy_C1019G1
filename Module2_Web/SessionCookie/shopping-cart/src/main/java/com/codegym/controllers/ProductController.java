package com.codegym.controllers;

import com.codegym.models.Product;
import com.codegym.services.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductServer productServer;

    @GetMapping("/")
    public ModelAndView begin() {
        //model.addAttribute("products",products);
        ModelAndView modelAndView = new ModelAndView("trangchu");
        modelAndView.addObject("products", productServer.findAll());
        return modelAndView;
    }

    @GetMapping("/chitiet/{id}")
    public ModelAndView chitiet(@PathVariable("id") Integer id) {
        Product product = productServer.findById(id);
        ModelAndView modelAndView = new ModelAndView("chitiet");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}
