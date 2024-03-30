package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.MauSac;
import com.example.duantotnghiep.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;
    @GetMapping("/view")
    public ModelAndView getAll(Model model){
        List<MauSac> list=mauSacService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("mauSac",new MauSac());
        return new ModelAndView("admin/product/mausac");
    }

    @PostMapping("/mau-sac/add")
    public String add(@ModelAttribute MauSac mauSac){
        mauSacService.add(mauSac);
        return "redirect:/view";
    }
    @GetMapping("/mau-sac/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        MauSac mauSac=mauSacService.detail(id);
        model.addAttribute("mauSac",mauSac);
        return "admin/product/mausac";
    }
    @GetMapping("/mau-sac/delete/{id}")
    public String delete(@PathVariable UUID id){
        mauSacService.delete(id);
        return "redirect:/view";
    }
    @PostMapping("/mau-sac/update/{id}")
    public String update(@ModelAttribute MauSac mauSac,@PathVariable UUID id){
        mauSacService.update(id,mauSac);
        return "redirect:/view";
    }

}
