package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.GioHangChiTietEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTietEntity, UUID> {
}
