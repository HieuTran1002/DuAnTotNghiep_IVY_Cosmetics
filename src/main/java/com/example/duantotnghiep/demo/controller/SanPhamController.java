package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.*;
import com.example.duantotnghiep.demo.service.*;
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
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private ThanhPhanService thanhPhanService;
    @Autowired
    private CongDungService congDungService;
    @Autowired
    private ThuongHieuService thuongHieuService;
    @Autowired
    private HinhDangService hinhDangService;
    @Autowired
    private XuatXuService xuatXuService;
    @Autowired
    private GiamGiaService giamGiaService;
    @GetMapping("/san-pham/view")
    public ModelAndView getAll(Model model){
        List<SanPhamEntity> list=sanPhamService.getAll();
        model.addAttribute("list",list);
        List<ThanhPhanEntity> thanhPhanEntity=thanhPhanService.getAll();
        model.addAttribute("thanhPhanEntity",thanhPhanEntity);
        List<CongDungEntity> congDungEntity=congDungService.getAll();
        model.addAttribute("congDungEntity",congDungEntity);
        List<ThuongHieuEntity> thuongHieuEntity=thuongHieuService.getAll();
        model.addAttribute("thuongHieuEntity",thuongHieuEntity);
        List<HinhDangEntity> hinhDangEntity=hinhDangService.getAll();
        model.addAttribute("hinhDangEntity",hinhDangEntity);
        List<XuatXuEntity> xuatXuEntity=xuatXuService.getAll();
        model.addAttribute("xuatXuEntity",xuatXuEntity);
        List<GiamGiaEntity> giamGiaEntity=giamGiaService.getAll();
        model.addAttribute("giamGiaEntity",giamGiaEntity);
        model.addAttribute("sanPhamEntity",new SanPhamEntity());
        return new ModelAndView("admin/product/sanpham");
    }
    @PostMapping("/san-pham/add")
    public String add(@ModelAttribute SanPhamEntity sanPhamEntity){
        sanPhamService.add(sanPhamEntity);
        return "redirect:/san-pham/view";
    }
    @GetMapping("/san-pham/delete/{id}")
    public String delete(@PathVariable UUID id){
        sanPhamService.delete(id);
        return "redirect:/san-pham/view";
    }
    @PostMapping("/san-pham/update/{id}")
    public String update(@ModelAttribute SanPhamEntity sanPhamEntity,@PathVariable UUID id){
        sanPhamService.update(id,sanPhamEntity);
        return "redirect:/san-pham/view";
    }
    @GetMapping("/san-pham/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        SanPhamEntity sanPhamEntity=sanPhamService.detail(id);
        model.addAttribute("sanPhamEntity",sanPhamEntity);
        List<ThanhPhanEntity> thanhPhanEntity=thanhPhanService.getAll();
        model.addAttribute("thanhPhanEntity",thanhPhanEntity);
        List<CongDungEntity> congDungEntity=congDungService.getAll();
        model.addAttribute("congDungEntity",congDungEntity);
        List<ThuongHieuEntity> thuongHieuEntity=thuongHieuService.getAll();
        model.addAttribute("thuongHieuEntity",thuongHieuEntity);
        List<HinhDangEntity> hinhDangEntity=hinhDangService.getAll();
        model.addAttribute("hinhDangEntity",hinhDangEntity);
        List<XuatXuEntity> xuatXuEntity=xuatXuService.getAll();
        model.addAttribute("xuatXuEntity",xuatXuEntity);
        List<GiamGiaEntity> giamGiaEntity=giamGiaService.getAll();
        model.addAttribute("giamGiaEntity",giamGiaEntity);
        return ("admin/product/sanpham");
    }
}
