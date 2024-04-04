package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.HinhDangEntity;
import com.example.duantotnghiep.demo.entity.MauSacEntity;

import java.util.List;
import java.util.UUID;

public interface HinhDangService {
    List<HinhDangEntity> getAll();
    HinhDangEntity add(HinhDangEntity hinhDangEntity);
    HinhDangEntity update(UUID id, HinhDangEntity hinhDangEntity);
    HinhDangEntity detail(UUID id);
    Boolean delete(UUID id);
}
