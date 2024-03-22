package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;
import com.example.duantotnghiep.demo.service.ThanhPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class ThanhPhanController {
    @Autowired
    private ThanhPhanService thanhPhanService;
    @GetMapping("/thanh-phan/view")
    public ModelAndView getAll(Model model){
        List<ThanhPhanEntity> list=thanhPhanService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("thanhPhanEntity",new ThanhPhanEntity());
        return new ModelAndView("admin/product/thanhphan");
    }
    @PostMapping("/thanh-phan/add")
    public String add(@ModelAttribute ThanhPhanEntity thanhPhanEntity){
        thanhPhanService.add(thanhPhanEntity);
        return "redirect:/thanh-phan/view";
    }
    @GetMapping("/thanh-phan/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        ThanhPhanEntity thanhPhanEntity=thanhPhanService.detail(id);
        model.addAttribute("thanhPhanEntity",thanhPhanEntity);
        return "admin/product/thanhphan";
    }
    @GetMapping("/thanh-phan/delete/{id}")
    public String delete(@PathVariable UUID id){
        thanhPhanService.delete(id);
        return "redirect:/thanh-phan/view";
    }
    @PostMapping("/thanh-phan/update/{id}")
    public String update(@PathVariable UUID id,@ModelAttribute ThanhPhanEntity thanhPhanEntity){
        thanhPhanService.update(id,thanhPhanEntity);
        return "redirect:/thanh-phan/view";
    }


}
