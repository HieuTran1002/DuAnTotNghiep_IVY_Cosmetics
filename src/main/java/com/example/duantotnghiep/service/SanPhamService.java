package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.SanPham;

import java.util.UUID;

public interface SanPhamService {

    SanPham applyDiscountAndAddToBill(UUID sanPhamId, UUID giamGiaId);
}
