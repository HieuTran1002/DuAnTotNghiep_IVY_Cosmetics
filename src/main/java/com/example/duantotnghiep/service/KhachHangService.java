package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.KhachHang;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KhachHangService {

    KhachHang createKhachHang(KhachHang khachHang);

    List<KhachHang> getAllKhachHangs();

    Optional<KhachHang> getKhachHangById(UUID id);

    KhachHang updateKhachHang(UUID id, KhachHang khachHang);

    void deleteKhachHang(UUID id);
}
