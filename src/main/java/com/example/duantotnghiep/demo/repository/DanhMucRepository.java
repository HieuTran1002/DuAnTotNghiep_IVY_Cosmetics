package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.DanhMucEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DanhMucRepository extends JpaRepository<DanhMucEntity, UUID> {
}
