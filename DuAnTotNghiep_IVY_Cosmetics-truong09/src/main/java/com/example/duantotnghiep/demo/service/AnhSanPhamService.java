package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.AnhSanPhamEntity;
import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;

import java.util.List;
import java.util.UUID;

public interface AnhSanPhamService {
    List<AnhSanPhamEntity> getAll();
    AnhSanPhamEntity add(AnhSanPhamEntity anhSanPhamEntity);
    AnhSanPhamEntity update(UUID id, AnhSanPhamEntity anhSanPhamEntity);
    AnhSanPhamEntity detail(UUID id);
    Boolean delete(UUID id);

}
