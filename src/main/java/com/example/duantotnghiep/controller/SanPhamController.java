package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.*;
import com.example.duantotnghiep.service.*;
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
    @GetMapping("/san-pham/view")
    public ModelAndView getAll(Model model){
        List<SanPham> list=sanPhamService.getAll();
        model.addAttribute("list",list);
        List<ThanhPhan> ThanhPhan=thanhPhanService.getAll();
        model.addAttribute("ThanhPhan",ThanhPhan);
        List<CongDung> CongDung=congDungService.getAll();
        model.addAttribute("CongDung",CongDung);
        List<ThuongHieu> ThuongHieu=thuongHieuService.getAll();
        model.addAttribute("ThuongHieu",ThuongHieu);
        List<HinhDang> HinhDang=hinhDangService.getAll();
        model.addAttribute("HinhDang",HinhDang);
        List<XuatXu> XuatXu=xuatXuService.getAll();
        model.addAttribute("XuatXu",XuatXu);
//        List<GiamGia> GiamGia=giamGiaService.getAll();
//        model.addAttribute("GiamGia",GiamGia);
        model.addAttribute("SanPham",new SanPham());
        return new ModelAndView("admin/product/sanpham");
    }
    @PostMapping("/san-pham/add")
    public String add(@ModelAttribute SanPham SanPham){
        sanPhamService.add(SanPham);
        return "redirect:/san-pham/view";
    }
    @GetMapping("/san-pham/delete/{id}")
    public String delete(@PathVariable UUID id){
        sanPhamService.delete(id);
        return "redirect:/san-pham/view";
    }
    @PostMapping("/san-pham/update/{id}")
    public String update(@ModelAttribute SanPham SanPham,@PathVariable UUID id){
        sanPhamService.update(id,SanPham);
        return "redirect:/san-pham/view";
    }
    @GetMapping("/san-pham/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        SanPham SanPham=sanPhamService.detail(id);
        model.addAttribute("SanPham",SanPham);
        List<ThanhPhan> ThanhPhan=thanhPhanService.getAll();
        model.addAttribute("ThanhPhan",ThanhPhan);
        List<CongDung> CongDung=congDungService.getAll();
        model.addAttribute("CongDung",CongDung);
        List<ThuongHieu> ThuongHieu=thuongHieuService.getAll();
        model.addAttribute("ThuongHieu",ThuongHieu);
        List<HinhDang> HinhDang=hinhDangService.getAll();
        model.addAttribute("HinhDang",HinhDang);
        List<XuatXu> XuatXu=xuatXuService.getAll();
        model.addAttribute("XuatXu",XuatXu);
//        List<GiamGia> GiamGia=giamGiaService.getAll();
//        model.addAttribute("GiamGia",GiamGia);
        return ("admin/product/sanpham");
    }
}
