package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.ThuongHieu;
import com.example.duantotnghiep.service.ThuongHieuService;
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
public class ThuongHieuController {
    @Autowired
    private ThuongHieuService thuongHieuService;
    @GetMapping("/thuong-hieu/view")
    public ModelAndView getAll(Model model){
        List<ThuongHieu> list=thuongHieuService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("thuongHieu",new ThuongHieu());
        return new ModelAndView("admin/product/thuonghieu");
    }
    @PostMapping("/thuong-hieu/add")
    public String add(@ModelAttribute ThuongHieu thuongHieu){
        thuongHieuService.add(thuongHieu);
        return "redirect:/thuong-hieu/view";
    }
    @GetMapping("/thuong-hieu/detail/{id}")
    public String detail(@PathVariable UUID id, Model model){
        ThuongHieu thuongHieu=thuongHieuService.detail(id);
        model.addAttribute("thuongHieu",thuongHieu);
        return "admin/product/thuonghieu";
    }
    @GetMapping("/thuong-hieu/delete/{id}")
    public String delete(@PathVariable UUID id){
        thuongHieuService.delete(id);
        return "redirect:/thuong-hieu/view";
    }
    @PostMapping("/thuong-hieu/update/{id}")
    public String update(@PathVariable UUID id,@ModelAttribute ThuongHieu thuongHieu){
        thuongHieuService.update(id,thuongHieu);
        return "redirect:/thuong-hieu/view";
    }
}
