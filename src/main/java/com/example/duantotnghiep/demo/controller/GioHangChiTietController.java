package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.GioHangChiTietEntity;
import com.example.duantotnghiep.demo.entity.GioHangEntity;
import com.example.duantotnghiep.demo.repository.GioHangRepository;
import com.example.duantotnghiep.demo.service.GioHangChiTietService;
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
public class GioHangChiTietController {
    @Autowired
    private GioHangChiTietService gioHangChiTietService;
    @Autowired
    private GioHangRepository gioHangRepository;
    @GetMapping("/gio-hang-chi-tiet/hien-thi")
    public ModelAndView getAll(Model model){
        List<GioHangChiTietEntity> list=gioHangChiTietService.getAll();
        model.addAttribute("list",list);
        List<GioHangEntity> gioHangEntities=gioHangRepository.findAll();
        model.addAttribute("gioHangEntities",gioHangEntities);
        model.addAttribute("gioHangChiTietEntity",new GioHangChiTietEntity());
        return new ModelAndView("user/gio_hang_chi_tiet");
    }
    @PostMapping("/gio-hang-chi-tiet/add")
    public String add(@ModelAttribute GioHangChiTietEntity gioHangChiTietEntity){
        gioHangChiTietService.add(gioHangChiTietEntity);
        return "redirect:/gio-hang-chi-tiet/hien-thi";
    }
    @GetMapping("/gio-hang-chi-tiet/detail")
    public String detail(@PathVariable UUID id,Model model){
        GioHangChiTietEntity gioHangChiTietEntity=gioHangChiTietService.detail(id);
        model.addAttribute("gioHangChiTietEntity",gioHangChiTietEntity);
        List<GioHangEntity> gioHangEntities=gioHangRepository.findAll();
        model.addAttribute("gioHangEntities",gioHangEntities);
        return "user/gio_hang_chi_tiet";
    }
    @GetMapping("/gio-hang-chi-tiet/delete/{id}")
    public String delete(@PathVariable UUID id){
        gioHangChiTietService.delete(id);
        return "redirect:/gio-hang-chi-tiet/hien-thi";
    }
    @PostMapping("/gio-hang-chi-tiet/update/{id}")
    public String update(@ModelAttribute GioHangChiTietEntity gioHangChiTietEntity,@PathVariable UUID id){
        gioHangChiTietService.update(id,gioHangChiTietEntity);
        return "redirect:/gio-hang-chi-tiet/hien-thi";
    }
}
