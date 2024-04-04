package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.HinhDangEntity;
import com.example.duantotnghiep.demo.entity.KhachHangEntity;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHangEntity> getAll();
    KhachHangEntity add(KhachHangEntity khachHangEntity);
    KhachHangEntity update(UUID id, KhachHangEntity khachHangEntity);
    KhachHangEntity detail(UUID id);
    Boolean delete(UUID id);
}
