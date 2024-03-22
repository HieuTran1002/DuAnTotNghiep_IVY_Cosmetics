package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.SanPhamChiTietEntity;
import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;

import java.util.List;
import java.util.UUID;

public interface SanPhamChiTietService {
    List<SanPhamChiTietEntity> getAll();
    SanPhamChiTietEntity add(SanPhamChiTietEntity sanPhamChiTietEntity);
    SanPhamChiTietEntity update(UUID id, SanPhamChiTietEntity sanPhamChiTietEntity);
    SanPhamChiTietEntity detail(UUID id);
    Boolean delete(UUID id);
}
