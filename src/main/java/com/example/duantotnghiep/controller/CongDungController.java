package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.CongDung;
import com.example.duantotnghiep.service.CongDungService;
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
public class CongDungController {
    @Autowired
    private CongDungService congDungService;
    @GetMapping("/cong-dung/view")
    public ModelAndView getAll(Model model){
        List<CongDung> list=congDungService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("congDung",new CongDung());
        return new ModelAndView("admin/product/congdung");
    }
    @PostMapping("/cong-dung/add")
    public String add(@ModelAttribute CongDung congDung){
         congDungService.add(congDung);
         return "redirect:/cong-dung/view";
    }
    @GetMapping("/cong-dung/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        CongDung congDung=congDungService.detail(id);
        model.addAttribute("congDung",congDung);
        return "admin/product/congdung";
    }
    @GetMapping("/cong-dung/delete/{id}")
    public String delete(@PathVariable UUID id){
        congDungService.delete(id);
        return "redirect:/cong-dung/view";
    }
    @PostMapping("/cong-dung/update/{id}")
    public String update(@ModelAttribute CongDung congDung,@PathVariable UUID id){
        congDungService.update(id,congDung);
        return "redirect:/cong-dung/view";
    }

}
