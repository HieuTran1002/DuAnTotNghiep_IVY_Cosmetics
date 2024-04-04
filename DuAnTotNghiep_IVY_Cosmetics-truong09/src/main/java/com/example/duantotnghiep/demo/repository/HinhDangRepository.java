package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.HinhDangEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HinhDangRepository extends JpaRepository<HinhDangEntity, UUID> {
}
