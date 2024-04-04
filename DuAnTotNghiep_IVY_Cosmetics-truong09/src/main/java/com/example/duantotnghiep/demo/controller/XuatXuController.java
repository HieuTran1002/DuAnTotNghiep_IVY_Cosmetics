package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;
import com.example.duantotnghiep.demo.entity.XuatXuEntity;
import com.example.duantotnghiep.demo.service.XuatXuService;
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
        List<XuatXuEntity> list=xuatXuService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("xuatXuEntity",new XuatXuEntity());
        return new ModelAndView("admin/product/xuatxu");
    }
    @PostMapping("/xuat-xu/add")
    public String add(@ModelAttribute XuatXuEntity xuatXuEntity){
        xuatXuService.add(xuatXuEntity);
        return "redirect:/xuat-xu/view";
    }
    @GetMapping("/xuat-xu/detail/{id}")
    public String detail(@PathVariable UUID id, Model model){
        XuatXuEntity xuatXuEntity=xuatXuService.detail(id);
        model.addAttribute("xuatXuEntity",xuatXuEntity);
        return "admin/product/xuatxu";
    }
    @GetMapping("/xuat-xu/delete/{id}")
    public String delete(@PathVariable UUID id){
        xuatXuService.delete(id);
        return "redirect:/xuat-xu/view";
    }
    @PostMapping("/xuat-xu/update/{id}")
    public String update(@PathVariable UUID id,@ModelAttribute XuatXuEntity xuatXuEntity){
        xuatXuService.update(id,xuatXuEntity);
        return "redirect:/xuat-xu/view";
    }
}
