package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.GiamGiaEntity;
import com.example.duantotnghiep.demo.entity.HinhDangEntity;

import java.util.List;
import java.util.UUID;

public interface GiamGiaService {
    List<GiamGiaEntity> getAll();
    GiamGiaEntity add(GiamGiaEntity giamGiaEntity);
    GiamGiaEntity update(UUID id, GiamGiaEntity giamGiaEntity);
    GiamGiaEntity detail(UUID id);
    Boolean delete(UUID id);
}
