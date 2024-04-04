package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.MauSacEntity;
import com.example.duantotnghiep.demo.service.MauSacService;
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
        List<MauSacEntity> list=mauSacService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("mauSacEntity",new MauSacEntity());
        return new ModelAndView("admin/product/mausac");
    }

    @PostMapping("/mau-sac/add")
    public String add(@ModelAttribute MauSacEntity mauSacEntity){
        mauSacService.add(mauSacEntity);
        return "redirect:/view";
    }
    @GetMapping("/mau-sac/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        MauSacEntity mauSacEntity=mauSacService.detail(id);
        model.addAttribute("mauSacEntity",mauSacEntity);
        return "admin/product/mausac";
    }
    @GetMapping("/mau-sac/delete/{id}")
    public String delete(@PathVariable UUID id){
        mauSacService.delete(id);
        return "redirect:/view";
    }
    @PostMapping("/mau-sac/update/{id}")
    public String update(@ModelAttribute MauSacEntity mauSacEntity,@PathVariable UUID id){
        mauSacService.update(id,mauSacEntity);
        return "redirect:/view";
    }

}
