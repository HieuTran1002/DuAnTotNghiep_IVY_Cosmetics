package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.CongDungEntity;
import com.example.duantotnghiep.demo.service.CongDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        List<CongDungEntity> list=congDungService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("congDungEntity",new CongDungEntity());
        return new ModelAndView("admin/product/congdung");
    }
    @PostMapping("/cong-dung/add")
    public String add(@ModelAttribute CongDungEntity congDungEntity){
         congDungService.add(congDungEntity);
         return "redirect:/cong-dung/view";
    }
    @GetMapping("/cong-dung/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        CongDungEntity congDungEntity=congDungService.detail(id);
        model.addAttribute("congDungEntity",congDungEntity);
        return "admin/product/congdung";
    }
    @GetMapping("/cong-dung/delete/{id}")
    public String delete(@PathVariable UUID id){
        congDungService.delete(id);
        return "redirect:/cong-dung/view";
    }
    @PostMapping("/cong-dung/update/{id}")
    public String update(@ModelAttribute CongDungEntity congDungEntity,@PathVariable UUID id){
        congDungService.update(id,congDungEntity);
        return "redirect:/cong-dung/view";
    }

}
