package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.NhanVien;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NhanVienService {

    NhanVien createNhanVien(NhanVien nhanVien);

    List<NhanVien> getAllNhanViens();

    Optional<NhanVien> getNhanVienById(UUID id);

    NhanVien updateNhanVien(UUID id, NhanVien nhanVien);

    void deleteNhanVien(UUID id);
}
