package com.codegym.cotrollers;

import com.codegym.services.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private DichVuService dichVuService;
    @GetMapping("/")
    public ModelAndView getHomePage(@RequestParam(value = "fromPrice", required = false) Double fromPrice
            ,@RequestParam(value = "toPrice", required = false) Double toPrice)
    {
        ModelAndView modelAndView = new ModelAndView("home/index");
        if (fromPrice == null || toPrice == null){
            modelAndView.addObject("listDichVu", dichVuService.getAllDichVu());
        }else {
            modelAndView.addObject("listDichVu",dichVuService.findAllByChiPhiThueBetween(fromPrice,toPrice));
        }
        return modelAndView;
    }
//    @GetMapping
//    public ModelAndView homePage() {
//        return new ModelAndView("home/index", "listDichVu", dichVuService.getAllDichVu());
//    }

    @GetMapping("/dichvu/{id}")
    public ModelAndView getDichVuDetail(@PathVariable long id) {
      return new ModelAndView("dichvu/dichvuchitiet","dichvuchitiet",dichVuService.getDichVu(id));

    }

}
