package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.*;
import com.example.duantotnghiep.demo.repository.SanPhamRepository;
import com.example.duantotnghiep.demo.service.DanhMucService;
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
public class DanhMucController {
    @Autowired
    private DanhMucService danhMucService;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @GetMapping("/danh-muc/view")
    public ModelAndView getAll(Model model){
        List<DanhMucEntity> list=danhMucService.getAll();
        model.addAttribute("list",list);
        List<SanPhamEntity> sanPhamEntity=sanPhamRepository.findAll();
        model.addAttribute("sanPhamEntity",sanPhamEntity);
        model.addAttribute("danhMucEntity",new DanhMucEntity());
        return new ModelAndView("admin/product/danhmuc");
    }
    @PostMapping("/danh-muc/add")
    public String add(@ModelAttribute DanhMucEntity danhMucEntity){
        danhMucService.add(danhMucEntity);
        return "redirect:/danh-muc/view";
    }
    @GetMapping("/danh-muc/delete/{id}")
    public String delete(@PathVariable UUID id){
        danhMucService.delete(id);
        return "redirect:/danh-muc/view";
    }
    @GetMapping("/danh-muc/detail/{id}")
    public String detail(@PathVariable UUID id, Model model){
        DanhMucEntity danhMucEntity=danhMucService.detail(id);
        model.addAttribute("danhMucEntity",danhMucEntity);
        List<SanPhamEntity> sanPhamEntities=sanPhamRepository.findAll();
        model.addAttribute("sanPhamEntity",sanPhamEntities);
        return "admin/product/danhmuc";
    }
    @PostMapping("/danh-muc/update/{id}")
    public String update(@ModelAttribute DanhMucEntity danhMucEntity,@PathVariable UUID id){
        danhMucService.update(id,danhMucEntity);
        return "redirect:/danh-muc/view";
    }
}
