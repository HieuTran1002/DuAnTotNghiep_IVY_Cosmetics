package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.GioHang;
import com.example.duantotnghiep.entity.GioHangChiTiet;
import com.example.duantotnghiep.entity.SanPhamChiTiet;
import com.example.duantotnghiep.repository.GioHangRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.UUID;

public class GioHangServiceImpl {

    @Autowired
    private GioHangRepository gioHangRepository;

    public GioHang createGioHang(GioHang GioHang) {
        return gioHangRepository.save(GioHang);
    }

//    public GioHang addToCart(GioHang cart, SanPhamChiTiet productDetail, int quantity) {
//        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
//        GioHangChiTiet existingItem = cart.get().stream()
//                .filter(item -> item.getProductDetail().equals(productDetail))
//                .findFirst()
//                .orElse(null);
//
//        if (existingItem != null) {
//            existingItem.setQuantity(existingItem.getQuantity() + quantity);
//        } else {
//            GioHangChiTiet newCartItem = new GioHangChiTiet();
//            newCartItem.setProductDetail(productDetail);
//            newCartItem.setQuantity(quantity);
//            newCartItem.setCart(cart);
//            cart.getCartDetails().add(newCartItem);
//        }
//
//        return gioHangRepository.save(cart);
//    }
//
//    public void removeGioHangItem(UUID GioHangId, UUID GioHangItemId) {
//        GioHang GioHang = gioHangRepository.findById(GioHangId).orElse(null);
//        if (GioHang == null) {
//            // Xử lý nếu giỏ hàng không tồn tại
//            return;
//        }
//
//        GioHang.getGioHangChiTiets().removeIf(item -> item.getId().equals(GioHangItemId));
//        gioHangRepository.save(GioHang);
//    }
//
//    public BigDecimal calculateTotalPrice(UUID GioHangId) {
//        GioHang GioHang = gioHangRepository.findById(GioHangId).orElse(null);
//        if (GioHang == null) {
//            // Xử lý nếu giỏ hàng không tồn tại
//            return BigDecimal.ZERO;
//        }
//
//        BigDecimal totalPrice = GioHang.getGioHangChiTiets().stream()
//                .map(item -> item.getProductDetail().getProduct().getSellingPrice()
//                        .multiply(BigDecimal.valueOf(item.getQuantity())))
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//        return totalPrice;
//    }
}
