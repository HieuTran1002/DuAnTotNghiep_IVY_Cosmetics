package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.SanPham;
import com.example.duantotnghiep.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/sanpham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @PatchMapping("/{sanPhamId}/giamgia/{giamGiaId}")
    public SanPham applyDiscount(@PathVariable UUID sanPhamId, @PathVariable UUID giamGiaId) {
        return sanPhamService.applyDiscountAndAddToBill(sanPhamId, giamGiaId);
    }
}
