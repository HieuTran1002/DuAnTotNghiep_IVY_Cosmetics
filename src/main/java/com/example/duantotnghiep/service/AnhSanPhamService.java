package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.AnhSanPham;

import java.util.List;
import java.util.UUID;

public interface AnhSanPhamService {
    List<AnhSanPham> getAll();
    AnhSanPham add(AnhSanPham AnhSanPham);
    AnhSanPham update(UUID id, AnhSanPham AnhSanPham);
    AnhSanPham detail(UUID id);
    Boolean delete(UUID id);

}
