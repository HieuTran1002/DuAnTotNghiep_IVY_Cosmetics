package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.HinhDang;
import com.example.duantotnghiep.service.HinhDangService;
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
public class HinhDangController {
    @Autowired
    private HinhDangService hinhDangService;
    @GetMapping("/hinh-dang/view")
    public ModelAndView getAll(Model model){
        List<HinhDang> list=hinhDangService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("hinhDang",new HinhDang());
        return new ModelAndView("admin/product/hinhdang");
    }
    @PostMapping("/hinh-dang/add")
    public String add(@ModelAttribute HinhDang hinhDang){
        hinhDangService.add(hinhDang);
        return "redirect:/hinh-dang/view";
    }
    @GetMapping("/hinh-dang/detail/{id}")
    public String detail(@PathVariable UUID id, Model model){
        HinhDang hinhDang=hinhDangService.detail(id);
        model.addAttribute("hinhDang",hinhDang);
        return "admin/product/hinhdang";
    }
    @GetMapping("/hinh-dang/delete/{id}")
    public String delete(@PathVariable UUID id){
        hinhDangService.delete(id);
        return "redirect:/hinh-dang/view";
    }
    @PostMapping("/hinh-dang/update/{id}")
    public String update(@PathVariable UUID id,@ModelAttribute HinhDang hinhDang){
        hinhDangService.update(id,hinhDang);
        return "redirect:/hinh-dang/view";
    }
}
