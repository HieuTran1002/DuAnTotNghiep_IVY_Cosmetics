package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.SanPhamEntity;
import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPhamEntity> getAll();
    SanPhamEntity add(SanPhamEntity sanPhamEntity);
    SanPhamEntity update(UUID id, SanPhamEntity sanPhamEntity);
    SanPhamEntity detail(UUID id);
    Boolean delete(UUID id);
}
