package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.*;
import com.example.duantotnghiep.demo.repository.SanPhamRepository;
import com.example.duantotnghiep.demo.service.AnhSanPhamService;
import com.example.duantotnghiep.demo.service.MauSacService;
import com.example.duantotnghiep.demo.service.SanPhamChiTietService;
import com.example.duantotnghiep.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class SanPhamChiTietController {
    @Autowired
    private SanPhamChiTietService sanPhamChiTietService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private AnhSanPhamService anhSanPhamService;
    @GetMapping("/san-pham-chi-tiet/view")
    public ModelAndView getAll(Model model){
        List<SanPhamChiTietEntity> list=sanPhamChiTietService.getAll();
        model.addAttribute("list",list);
        List<SanPhamEntity> sanPhamEntity=sanPhamService.getAll();
        model.addAttribute("sanPhamEntity",sanPhamEntity);
        List<MauSacEntity> mauSacEntity=mauSacService.getAll();
        model.addAttribute("mauSacEntity",mauSacEntity);
        List<AnhSanPhamEntity> anhSanPhamEntity=anhSanPhamService.getAll();
        model.addAttribute("anhSanPhamEntity",anhSanPhamEntity);
        model.addAttribute("sanPhamChiTietEntity",new SanPhamChiTietEntity());
        return new ModelAndView("user/san_pham_chi_tiet");
    }
    @PostMapping("/san-pham-chi-tiet/add")
    public String add(@ModelAttribute SanPhamChiTietEntity sanPhamChiTietEntity){
        sanPhamChiTietService.add(sanPhamChiTietEntity);
        return "redirect:/san-pham-chi-tiet/view";
    }
    @GetMapping("/san-pham-chi-tiet/detail/{id}")
    public String detail(@PathVariable UUID id, Model model){
        SanPhamChiTietEntity sanPhamChiTietEntity=sanPhamChiTietService.detail(id);
        model.addAttribute("sanPhamChiTietEntity",sanPhamChiTietEntity);
        List<SanPhamEntity> sanPhamEntity=sanPhamService.getAll();
        model.addAttribute("sanPhamEntity",sanPhamEntity);
        List<MauSacEntity> mauSacEntity=mauSacService.getAll();
        model.addAttribute("mauSacEntity",mauSacEntity);
        List<AnhSanPhamEntity> anhSanPhamEntity=anhSanPhamService.getAll();
        model.addAttribute("anhSanPhamEntity",anhSanPhamEntity);
        return "user/san_pham_chi_tiet";
    }
    @GetMapping("/san-pham-chi-tiet/delete/{id}")
    public String delete(@PathVariable UUID id){
        sanPhamChiTietService.delete(id);
        return "redirect:/san-pham-chi-tiet/view";
    }
    @PostMapping("/san-pham-chi-tiet/update/{id}")
    public String update(@ModelAttribute SanPhamChiTietEntity sanPhamChiTietEntity,@PathVariable UUID id){
        sanPhamChiTietService.update(id,sanPhamChiTietEntity);
        return "redirect:/san-pham-chi-tiet/view";
    }
}
