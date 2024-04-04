package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.*;
import com.example.duantotnghiep.demo.repository.GioHangChiTietRepository;
import com.example.duantotnghiep.demo.repository.GioHangRepository;
import com.example.duantotnghiep.demo.repository.KhachHangRepository;
import com.example.duantotnghiep.demo.repository.SanPhamChiTietRepository;
import com.example.duantotnghiep.demo.service.SanPhamChiTietService;
import com.example.duantotnghiep.demo.service.impl.ShoppingCartServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class CartController {
    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    private HttpSession session;

    @PostMapping("/cart/add/{customerId}/{chiTietId}")
    public String addToCart(@PathVariable UUID customerId, @PathVariable UUID chiTietId) {
        UUID gioHangId = shoppingCartService.findCreatCardByCustomerId(customerId,session);
        shoppingCartService.addToCart(gioHangId, chiTietId);
        return "redirect:/cart/" + gioHangId;
    }

    @GetMapping("/cart/{gioHangId}")
    public String getCartByGioHangId(Model model) {
        List<GioHangChiTietEntity> cartItems = shoppingCartService.getCartByGioHangId(session);
        model.addAttribute("cartItems", cartItems);
        BigDecimal totalPrice = shoppingCartService.sumTotalPrice(cartItems);
        BigDecimal viDiem=BigDecimal.valueOf(0);
        BigDecimal sumOfCart=totalPrice.subtract(viDiem);
        model.addAttribute("sumOfCart",sumOfCart);
        model.addAttribute("viDiem",viDiem);
        model.addAttribute("totalPrice", totalPrice);
        return "user/cart";
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session) {
        UUID gioHangId = (UUID) session.getAttribute("gioHangId");
        if(gioHangId == null){
            return "user/cart";
        }
        return "redirect:/cart/" + gioHangId;
    }


    @PostMapping("/cart/remove/{id}")
    public String removeCart(@RequestParam("id") String cartItemId, Model model, HttpSession session) {
        UUID itemId;
        try {
            itemId = UUID.fromString(cartItemId);
        } catch (IllegalArgumentException e) {
            // Xử lý khi chuỗi không hợp lệ
            return "redirect:/cart";
        }
        shoppingCartService.removeCart(itemId);
        UUID gioHangId = (UUID) session.getAttribute("gioHangId");
        return "redirect:/cart/" + gioHangId;
    }

}
