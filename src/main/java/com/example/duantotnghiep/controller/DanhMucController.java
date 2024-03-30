package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.DanhMuc;
import com.example.duantotnghiep.entity.SanPham;
import com.example.duantotnghiep.repository.SanPhamRepository;
import com.example.duantotnghiep.service.DanhMucService;
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
        List<DanhMuc> list=danhMucService.getAll();
        model.addAttribute("list",list);
        List<SanPham> SanPham=sanPhamRepository.findAll();
        model.addAttribute("SanPham",SanPham);
        model.addAttribute("DanhMuc",new DanhMuc());
        return new ModelAndView("admin/product/danhmuc");
    }
    @PostMapping("/danh-muc/add")
    public String add(@ModelAttribute DanhMuc DanhMuc){
        danhMucService.add(DanhMuc);
        return "redirect:/danh-muc/view";
    }
    @GetMapping("/danh-muc/delete/{id}")
    public String delete(@PathVariable UUID id){
        danhMucService.delete(id);
        return "redirect:/danh-muc/view";
    }
    @GetMapping("/danh-muc/detail/{id}")
    public String detail(@PathVariable UUID id, Model model){
        DanhMuc DanhMuc=danhMucService.detail(id);
        model.addAttribute("DanhMuc",DanhMuc);
        List<SanPham> sanPhamEntities=sanPhamRepository.findAll();
        model.addAttribute("SanPham",sanPhamEntities);
        return "admin/product/danhmuc";
    }
    @PostMapping("/danh-muc/update/{id}")
    public String update(@ModelAttribute DanhMuc DanhMuc,@PathVariable UUID id){
        danhMucService.update(id,DanhMuc);
        return "redirect:/danh-muc/view";
    }
}
