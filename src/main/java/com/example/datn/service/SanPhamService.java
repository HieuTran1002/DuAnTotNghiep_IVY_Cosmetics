package com.example.datn.service;

import com.example.datn.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();
    SanPham detail(UUID id);
    void create(SanPham sanPham);
    void update(SanPham sanPham);
    void remove(UUID id);
    //Chua viet phan trang
}
