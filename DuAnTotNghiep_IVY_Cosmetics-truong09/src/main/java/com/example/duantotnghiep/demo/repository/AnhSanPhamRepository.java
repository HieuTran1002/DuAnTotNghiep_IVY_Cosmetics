package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.AnhSanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnhSanPhamRepository extends JpaRepository<AnhSanPhamEntity, UUID> {
}
