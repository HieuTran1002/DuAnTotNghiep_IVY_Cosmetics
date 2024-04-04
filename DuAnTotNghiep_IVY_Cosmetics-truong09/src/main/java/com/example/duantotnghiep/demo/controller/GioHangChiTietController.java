package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.GioHangChiTietEntity;
import com.example.duantotnghiep.demo.entity.GioHangEntity;
import com.example.duantotnghiep.demo.entity.SanPhamChiTietEntity;
import com.example.duantotnghiep.demo.repository.GioHangRepository;
import com.example.duantotnghiep.demo.service.GioHangChiTietService;
import com.example.duantotnghiep.demo.service.SanPhamChiTietService;
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
public class GioHangChiTietController {
    @Autowired
    private GioHangChiTietService gioHangChiTietService;
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private SanPhamChiTietService sanPhamChiTietService;
    @GetMapping("/gio-hang-chi-tiet/view")
    public ModelAndView getAll(Model model){
        List<GioHangChiTietEntity> list=gioHangChiTietService.getAll();
        model.addAttribute("list",list);
        List<GioHangEntity> gioHang=gioHangRepository.findAll();
        model.addAttribute("gioHang",gioHang);
        List<SanPhamChiTietEntity> sanPhamChiTietEntity=sanPhamChiTietService.getAll();
        model.addAttribute("sanPhamChiTietEntity",sanPhamChiTietEntity);
        model.addAttribute("gioHangChiTietEntity",new GioHangChiTietEntity());
        return new ModelAndView("user/cart");
    }
    @PostMapping("/gio-hang-chi-tiet/add")
    public String add(@ModelAttribute GioHangChiTietEntity gioHangChiTietEntity){
        gioHangChiTietService.add(gioHangChiTietEntity);
        return "redirect:/gio-hang-chi-tiet/view";
    }
    @GetMapping("/gio-hang-chi-tiet/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        GioHangChiTietEntity gioHangChiTietEntity=gioHangChiTietService.detail(id);
        model.addAttribute("gioHangChiTietEntity",gioHangChiTietEntity);
        List<GioHangEntity> gioHang=gioHangRepository.findAll();
        model.addAttribute("gioHang",gioHang);
        List<SanPhamChiTietEntity> sanPhamChiTietEntity=sanPhamChiTietService.getAll();
        model.addAttribute("sanPhamChiTietEntity",sanPhamChiTietEntity);
        return "user/gio_hang_chi_tiet";
    }
    @GetMapping("/gio-hang-chi-tiet/delete/{id}")
    public String delete(@PathVariable UUID id){
        gioHangChiTietService.delete(id);
        return "redirect:/gio-hang-chi-tiet/view";
    }
    @PostMapping("/gio-hang-chi-tiet/update/{id}")
    public String update(@ModelAttribute GioHangChiTietEntity gioHangChiTietEntity,@PathVariable UUID id){
        gioHangChiTietService.update(id,gioHangChiTietEntity);
        return "redirect:/gio-hang-chi-tiet/view";
    }
}
