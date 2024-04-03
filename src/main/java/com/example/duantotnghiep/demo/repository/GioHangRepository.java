package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.GioHangEntity;
import com.example.duantotnghiep.demo.entity.KhachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GioHangRepository extends JpaRepository<GioHangEntity, UUID> {
    GioHangEntity findByKhachHangEntity(KhachHangEntity khachHangEntity);
}
