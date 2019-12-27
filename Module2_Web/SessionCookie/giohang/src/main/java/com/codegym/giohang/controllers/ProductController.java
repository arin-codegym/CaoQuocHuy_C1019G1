package com.codegym.giohang.controllers;

import com.codegym.giohang.models.Cart;
import com.codegym.giohang.models.Product;
import com.codegym.giohang.repository.ProductRepository;
import com.codegym.giohang.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {
private Map<Product,Integer> cart = new HashMap<>();
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setUpUserForm() {
        return new Cart();
    }
    @GetMapping("/")
    public ModelAndView view() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/view-product/{id}")
    public ModelAndView view_information(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("information", "product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/view-product/{id}")
    public ModelAndView addCart(@PathVariable Long id , @ModelAttribute("cart") Cart cart) {
        Product product=productService.findById(id);
        ModelAndView modelAndView=new ModelAndView("view");
        modelAndView.addObject("product",product);
        if (product==null){
            modelAndView.addObject("message","Error");
        }else{
            cart.addToCart(product);
            modelAndView.addObject("message","Add "+product.getProductName()+" to cart successfully\nAmount: "+cart.getAmount(product));
        }
        System.out.println("test");
        System.out.println(cart.getCart().toString());
        return modelAndView;
    }
    @GetMapping("/cart")
    public ModelAndView goToCart(@ModelAttribute("cart") Cart cart){
        return new ModelAndView("cart","list",cart.getCart());
    }

}
