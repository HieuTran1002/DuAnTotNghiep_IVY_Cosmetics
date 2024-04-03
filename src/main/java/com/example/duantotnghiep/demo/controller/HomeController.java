package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.AnhSanPhamEntity;
import com.example.duantotnghiep.demo.entity.SanPhamChiTietEntity;
import com.example.duantotnghiep.demo.entity.SanPhamEntity;
import com.example.duantotnghiep.demo.service.AnhSanPhamService;
import com.example.duantotnghiep.demo.service.SanPhamChiTietService;
import com.example.duantotnghiep.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private SanPhamChiTietService sanPhamChiTietService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private AnhSanPhamService anhSanPhamService;

    @GetMapping("/home/view")
    public ModelAndView getAll(Model model){
        List<SanPhamChiTietEntity> list=sanPhamChiTietService.getAll();
        model.addAttribute("list",list);
        List<SanPhamEntity> sanPhamEntity=sanPhamService.getAll();
        model.addAttribute("sanPhamEntity",sanPhamEntity);
        List<AnhSanPhamEntity> anhSanPhamEntity=anhSanPhamService.getAll();
        model.addAttribute("anhSanPhamEntity",anhSanPhamEntity);
        return new ModelAndView("user/home");
    }
}
