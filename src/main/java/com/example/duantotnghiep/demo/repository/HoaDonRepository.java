package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.HoaDonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoaDonRepository extends JpaRepository<HoaDonEntity, UUID> {
}
