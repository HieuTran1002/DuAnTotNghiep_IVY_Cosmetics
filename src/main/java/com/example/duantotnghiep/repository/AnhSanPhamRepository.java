package com.example.duantotnghiep.repository;

import com.example.duantotnghiep.entity.AnhSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnhSanPhamRepository extends JpaRepository<AnhSanPham, UUID> {
}
