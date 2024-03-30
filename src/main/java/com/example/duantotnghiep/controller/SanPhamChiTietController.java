//package com.example.duantotnghiep.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.Response;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//import java.util.UUID;
//
//@Controller
//public class SanPhamChiTietController {
//    @Autowired
//    private SanPhamChiTietService sanPhamChiTietService;
//    @Autowired
//    private SanPhamRepository sanPhamRepository;
//    @Autowired
//    private MauSacService mauSacService;
//    @Autowired
//    private AnhSanPhamService anhSanPhamService;
//    @GetMapping("/san-pham-chi-tiet/view")
//    public ModelAndView getAll(Model model){
//        List<SanPhamChiTiet> list=sanPhamChiTietService.getAll();
//        model.addAttribute("list",list);
//        List<SanPham> sanPhamEntities=sanPhamRepository.findAll();
//        model.addAttribute("sanPhamEntities",sanPhamEntities);
//        List<MauSac> mauSacEntities=mauSacService.getAll();
//        model.addAttribute("mauSacEntities",mauSacEntities);
//        List<AnhSanPham> anhSanPhamEntities=anhSanPhamService.getAll();
//        model.addAttribute("anhSanPhamEntities",anhSanPhamEntities);
//        model.addAttribute("sanPhamChiTiet",new SanPhamChiTiet());
//        return new ModelAndView("user/san_pham_chi_tiet");
//    }
//    @PostMapping("/san-pham-chi-tiet/add")
//    public String add(@ModelAttribute SanPhamChiTiet sanPhamChiTiet){
//        sanPhamChiTietService.add(sanPhamChiTiet);
//        return "redirect:/san-pham-chi-tiet/view";
//    }
//    @GetMapping("/san-pham-chi-tiet/detail/{id}")
//    public String detail(@PathVariable UUID id, Model model){
//        SanPhamChiTiet sanPhamChiTiet=sanPhamChiTietService.detail(id);
//        model.addAttribute("sanPhamChiTiet",sanPhamChiTiet);
//        List<SanPham> sanPhamEntities=sanPhamRepository.findAll();
//        model.addAttribute("sanPhamEntities",sanPhamEntities);
//        List<MauSac> mauSacEntities=mauSacService.getAll();
//        model.addAttribute("mauSacEntities",mauSacEntities);
//        List<AnhSanPham> anhSanPhamEntities=anhSanPhamService.getAll();
//        model.addAttribute("anhSanPhamEntities",anhSanPhamEntities);
//        return "user/san_pham_chi_tiet";
//    }
//    @GetMapping("/san-pham-chi-tiet/delete/{id}")
//    public String delete(@PathVariable UUID id){
//        sanPhamChiTietService.delete(id);
//        return "redirect:/san-pham-chi-tiet/view";
//    }
//    @PostMapping("/san-pham-chi-tiet/update/{id}")
//    public String update(@ModelAttribute SanPhamChiTiet sanPhamChiTiet,@PathVariable UUID id){
//        sanPhamChiTietService.update(id,sanPhamChiTiet);
//        return "redirect:/san-pham-chi-tiet/view";
//    }
//}
