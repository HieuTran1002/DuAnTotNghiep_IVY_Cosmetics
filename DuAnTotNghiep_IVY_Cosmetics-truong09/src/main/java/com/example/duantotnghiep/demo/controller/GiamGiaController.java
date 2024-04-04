package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.GiamGiaEntity;
import com.example.duantotnghiep.demo.entity.HinhDangEntity;
import com.example.duantotnghiep.demo.service.GiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class GiamGiaController {
    @Autowired
    private GiamGiaService giamGiaService;
    @GetMapping("/giam-gia/view")
    public ModelAndView getAll(Model model){
        List<GiamGiaEntity> list=giamGiaService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("giamGiaEntity",new GiamGiaEntity());
        return new ModelAndView("admin/voucher/dotgiamgia");
    }
    @PostMapping("/giam-gia/add")
    public String add(@ModelAttribute GiamGiaEntity giamGiaEntity){
        giamGiaService.add(giamGiaEntity);
        return "redirect:/giam-gia/view";
    }
    @GetMapping("/giam-gia/detail/{id}")
    public String detail(@PathVariable UUID id, Model model){
        GiamGiaEntity giamGiaEntity=giamGiaService.detail(id);
        model.addAttribute("giamGiaEntity",giamGiaEntity);
        return "admin/voucher/dotgiamgia";
    }
    @GetMapping("/giam-gia/delete/{id}")
    public String delete(@PathVariable UUID id){
        giamGiaService.delete(id);
        return "redirect:/giam-gia/view";
    }
    @PostMapping("/giam-gia/update/{id}")
    public String update(@PathVariable UUID id,@ModelAttribute GiamGiaEntity giamGiaEntity){
        giamGiaService.update(id,giamGiaEntity);
        return "redirect:/giam-gia/view";
    }
}
