package com.example.datn.service;

import com.example.datn.entity.DanhMuc;
import com.example.datn.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface DanhMucService {
    List<DanhMuc> getAll();
    DanhMuc detail(UUID id);
    void create(DanhMuc danhMuc);
    void update(DanhMuc danhMuc);
    void remove(UUID id);
}
