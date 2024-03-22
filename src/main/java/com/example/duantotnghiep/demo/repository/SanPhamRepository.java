package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.SanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPhamEntity, UUID> {
}
