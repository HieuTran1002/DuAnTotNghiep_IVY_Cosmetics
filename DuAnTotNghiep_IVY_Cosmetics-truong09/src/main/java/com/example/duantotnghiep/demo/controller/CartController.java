package com.example.duantotnghiep.demo.controller;

import com.example.duantotnghiep.demo.entity.GioHangChiTietEntity;
import com.example.duantotnghiep.demo.repository.GioHangRepository;
import com.example.duantotnghiep.demo.service.impl.ShoppingCartServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
public class CartController {
    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    private HttpSession session;

//    @Autowired
//    private

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
        BigDecimal vidiem = BigDecimal.valueOf(0);
        BigDecimal sumOfCart = totalPrice.subtract(vidiem);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("vidiem", vidiem);
        model.addAttribute("sumOfCart", sumOfCart);
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
