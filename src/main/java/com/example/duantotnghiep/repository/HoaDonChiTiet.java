package com.example.duantotnghiep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HoaDonChiTiet extends JpaRepository<HoaDonChiTiet, UUID> {
}
