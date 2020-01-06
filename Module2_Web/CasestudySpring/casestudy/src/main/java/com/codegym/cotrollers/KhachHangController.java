package com.codegym.cotrollers;

import com.codegym.entity.FuramaKhachHang;
import com.codegym.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;

    @GetMapping("/dangkykhachhang")
    public String getTrangDangKy(Model model){
        model.addAttribute("khachhang", new FuramaKhachHang());
        return "khachhang/trangdangky";
    }

    @PostMapping("/dangky")
    public String saveKhachHang(@Valid @ModelAttribute("khachhang")FuramaKhachHang furamaKhachHang, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "khachhang/trangdangky";
        }else {
            khachHangService.saveKhachHang(furamaKhachHang);
            return "khachhang/dangkythanhcong";
        }
}
}
