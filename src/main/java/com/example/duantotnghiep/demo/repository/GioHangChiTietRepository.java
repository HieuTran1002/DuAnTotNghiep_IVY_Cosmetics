package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.GioHangChiTietEntity;
import com.example.duantotnghiep.demo.entity.GioHangEntity;
import com.example.duantotnghiep.demo.entity.SanPhamChiTietEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTietEntity, UUID> {
    GioHangChiTietEntity findByGioHangAndSanPhamChiTietEntity(GioHangEntity gioHangEntity, SanPhamChiTietEntity sanPhamChiTietEntity);
}
