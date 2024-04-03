package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.TaiKhoan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaiKhoanService {

    TaiKhoan createTaiKhoan(TaiKhoan taiKhoan);

    List<TaiKhoan> getAllTaiKhoans();

    Optional<TaiKhoan> getTaiKhoanById(UUID id);

    TaiKhoan updateTaiKhoan(UUID id, TaiKhoan taiKhoan);

    void deleteTaiKhoan(UUID id);

    String getRoles(TaiKhoan taiKhoan);

    boolean authenticationSuccess(int role);
}
