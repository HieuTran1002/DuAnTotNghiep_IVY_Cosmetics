package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.ThanhPhan;
import com.example.duantotnghiep.service.ThanhPhanService;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<ThanhPhan> list=thanhPhanService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("thanhPhan",new ThanhPhan());
        return new ModelAndView("admin/product/thanhphan");
    }
    @PostMapping("/thanh-phan/add")
    public String add(@ModelAttribute ThanhPhan thanhPhan){
        thanhPhanService.add(thanhPhan);
        return "redirect:/thanh-phan/view";
    }
    @GetMapping("/thanh-phan/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        ThanhPhan thanhPhan=thanhPhanService.detail(id);
        model.addAttribute("thanhPhan",thanhPhan);
        return "admin/product/thanhphan";
    }
    @GetMapping("/thanh-phan/delete/{id}")
    public String delete(@PathVariable UUID id){
        thanhPhanService.delete(id);
        return "redirect:/thanh-phan/view";
    }
    @PostMapping("/thanh-phan/update/{id}")
    public String update(@PathVariable UUID id,@ModelAttribute ThanhPhan thanhPhan){
        thanhPhanService.update(id,thanhPhan);
        return "redirect:/thanh-phan/view";
    }


}
