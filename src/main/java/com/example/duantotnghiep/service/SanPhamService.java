package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    SanPham applyDiscountAndAddToBill(UUID sanPhamId, UUID giamGiaId);

    List<SanPham> getAll();
    
    SanPham add(SanPham SanPham);
    
    SanPham update(UUID id, SanPham SanPham);
    
    SanPham detail(UUID id);
    
    Boolean delete(UUID id);
}
