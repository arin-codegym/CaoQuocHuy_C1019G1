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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
@SessionAttributes("cart")
public class ProductController {
   // private Map<Product, Integer> cart = new HashMap<>();
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public HashMap<Long, Object> setUpUserForm() {
        return new HashMap<>();
    }

    @GetMapping("/")
    public ModelAndView view() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/view-product/{id}")
    public ModelAndView view_information(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("information");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/view-product/{id}")
    public ModelAndView addCart(@PathVariable Long id, @ModelAttribute("cart") HashMap list) {
        int quantity = 1;

        HashMap<Long, Cart> listCard = new HashMap<>();
       Cart item=new Cart();
        Product product = productService.findById(id);
        listCard.put((long) id, item(product,item.getQuantity(item.setQuantity(1))));
        if (listCard.containsKey((long) id)) {
            listCard.replace((long) id,  Cart(product,quantity+=1));

        }
        list.putAll(listCard);
       System.out.println(listCard);
        ModelAndView modelAndView = new ModelAndView("information", "product", product);
        modelAndView.addObject("message", "add ok");
        //  modelAndView.addObject("list",cart);

        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView goToCart(@ModelAttribute("cart") HashMap list) {
        double total=0;
        Set<Long> keys = list.keySet();
        Long[] arrayKey=keys.toArray(new Long[keys.size()]);
        for(long idCart:arrayKey) {
            Cart cart= (Cart) list.get(idCart);
            System.out.println(cart.getProduct().getName());
//            Object value = entry.getValue();

            // do what you have to do here
            // In your case, another loop.
        }

//        for ( tol:list.keySet()){
//            total = list.get(tol)
//        }
        return new ModelAndView("giohang","list",list);
    }

}
