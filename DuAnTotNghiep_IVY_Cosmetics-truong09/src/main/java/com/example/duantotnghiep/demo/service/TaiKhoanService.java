package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.TaiKhoanEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaiKhoanService {
    Optional<TaiKhoanEntity> findByUserName(String userName);

    TaiKhoanEntity createTaiKhoan(TaiKhoanEntity taiKhoan);

    List<TaiKhoanEntity> getAllTaiKhoans();

    Optional<TaiKhoanEntity> getTaiKhoanById(UUID id);

    TaiKhoanEntity updateTaiKhoan(UUID id, TaiKhoanEntity taiKhoan);

    void deleteTaiKhoan(UUID id);

    String getRoles(TaiKhoanEntity taiKhoan);

    boolean authenticationSuccess(int role);
}
