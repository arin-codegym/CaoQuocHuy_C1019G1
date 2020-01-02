package com.codegym.cotrollers;

import com.codegym.services.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private DichVuService dichVuService;
    @GetMapping
    public ModelAndView homePage(){
        return new ModelAndView("home/index","listDichVu",dichVuService.getAllDichVu());
    }
}
