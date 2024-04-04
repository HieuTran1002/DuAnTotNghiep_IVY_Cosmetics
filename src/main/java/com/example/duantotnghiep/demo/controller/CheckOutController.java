package com.example.duantotnghiep.demo.controller;


import com.example.duantotnghiep.demo.entity.GioHangChiTietEntity;
import com.example.duantotnghiep.demo.entity.KhachHangEntity;
import com.example.duantotnghiep.demo.repository.KhachHangRepository;
import com.example.duantotnghiep.demo.service.KhachHangService;
import com.example.duantotnghiep.demo.service.impl.ShoppingCartServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
public class CheckOutController {
    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    private HttpSession session;
    @GetMapping("/check-out/view")
    public ModelAndView getAll(@RequestParam(name = "customerPayment", defaultValue = "0") BigDecimal customerPayment,
                               Model model) {
        ModelAndView modelAndView = new ModelAndView("user/checkout");
        modelAndView.addObject("customerPayment", customerPayment);
        List<GioHangChiTietEntity> cartItems = shoppingCartService.getCartByGioHangId(session);
        model.addAttribute("cartItems", cartItems);
        BigDecimal totalPrice=shoppingCartService.sumTotalPrice(cartItems);
//        BigDecimal viDiem = BigDecimal.valueOf(0);// Sau CRUD Ví điểm thì sẽ thành BigDecimal.valueOf(viDiemService.getTotal());
        BigDecimal sumOfCheckOut = totalPrice.subtract(customerPayment);
        model.addAttribute("totalPrice",totalPrice);
//        model.addAttribute("viDiem",viDiem);
        model.addAttribute("sumOfCheckOut",sumOfCheckOut);
        List<KhachHangEntity> list=khachHangService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("khachHangEntity",new KhachHangEntity());
        return modelAndView;
    }
    @PostMapping("/check-out/add")
    public String add(@ModelAttribute("khachHangEntity") KhachHangEntity khachHangEntity) {
        khachHangService.add(khachHangEntity);
        return "redirect:/check-out/view";
    }
    @GetMapping("/check-out/detail/{id}")
    public String detail(@RequestParam("khachHangEntity") UUID khachHangId, Model model){
        KhachHangEntity khachHangEntity=khachHangService.detail(khachHangId);
        model.addAttribute("khachHangEntity",khachHangEntity);
        return "redirect:/check-out/view";
    }
}
