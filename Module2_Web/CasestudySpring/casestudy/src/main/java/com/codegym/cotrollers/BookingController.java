package com.codegym.cotrollers;

import com.codegym.entity.FuramaDichVu;
import com.codegym.services.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class BookingController {
   @Autowired
   private DichVuService dichVuService;
    @GetMapping("/booking/{id}")
    public ModelAndView getBookingPage(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("dichvu/booking");
        FuramaDichVu furamaDichVu = dichVuService.getDichVu(id);
        modelAndView.addObject("dichvu", furamaDichVu);
        return modelAndView;

    }
}
