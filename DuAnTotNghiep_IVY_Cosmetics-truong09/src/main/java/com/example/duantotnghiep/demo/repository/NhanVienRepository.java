package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVienEntity, UUID> {
}
