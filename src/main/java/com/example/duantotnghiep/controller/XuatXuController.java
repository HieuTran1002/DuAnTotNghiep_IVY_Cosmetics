package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.XuatXu;
import com.example.duantotnghiep.service.XuatXuService;
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
public class XuatXuController {
    @Autowired
    private XuatXuService xuatXuService;
    @GetMapping("/xuat-xu/view")
    public ModelAndView getAll(Model model){
        List<XuatXu> list=xuatXuService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("xuatXu",new XuatXu());
        return new ModelAndView("admin/product/xuatxu");
    }
    @PostMapping("/xuat-xu/add")
    public String add(@ModelAttribute XuatXu xuatXu){
        xuatXuService.add(xuatXu);
        return "redirect:/xuat-xu/view";
    }
    @GetMapping("/xuat-xu/detail/{id}")
    public String detail(@PathVariable UUID id, Model model){
        XuatXu xuatXu=xuatXuService.detail(id);
        model.addAttribute("xuatXu",xuatXu);
        return "admin/product/xuatxu";
    }
    @GetMapping("/xuat-xu/delete/{id}")
    public String delete(@PathVariable UUID id){
        xuatXuService.delete(id);
        return "redirect:/xuat-xu/view";
    }
    @PostMapping("/xuat-xu/update/{id}")
    public String update(@PathVariable UUID id,@ModelAttribute XuatXu xuatXu){
        xuatXuService.update(id,xuatXu);
        return "redirect:/xuat-xu/view";
    }
}
