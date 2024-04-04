package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.TaiKhoanEntity;

import java.util.Optional;

public interface TaiKhoanService {
    Optional<TaiKhoanEntity> findByUserName(String userName);
}
