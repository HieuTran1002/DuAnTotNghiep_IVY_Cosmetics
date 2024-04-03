package com.example.duantotnghiep.demo.controller;


import com.example.duantotnghiep.demo.entity.KhachHangEntity;
import com.example.duantotnghiep.demo.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class CheckOutController {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("/check-out/view")
    public ModelAndView getAll(Model model, @PathVariable UUID idKhachHang) {
        List<KhachHangEntity> list = khachHangRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("khachHangEntity", new KhachHangEntity());
        KhachHangEntity khachHangEntity = khachHangRepository.findById(idKhachHang).orElse(null);
        model.addAttribute("khachHangEntity", khachHangEntity);
        return new ModelAndView("user/checkout");
    }
}
