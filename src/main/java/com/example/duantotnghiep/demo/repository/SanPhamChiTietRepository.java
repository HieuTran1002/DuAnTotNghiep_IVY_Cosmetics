package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.SanPhamChiTietEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTietEntity, UUID> {
}
