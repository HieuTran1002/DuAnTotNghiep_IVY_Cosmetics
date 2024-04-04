package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.GioHangChiTietEntity;
import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {
    List<GioHangChiTietEntity> getAll();
    GioHangChiTietEntity add(GioHangChiTietEntity gioHangChiTietEntity);
    GioHangChiTietEntity update(UUID id, GioHangChiTietEntity gioHangChiTietEntity);
    GioHangChiTietEntity detail(UUID id);
    Boolean delete(UUID id);
}
