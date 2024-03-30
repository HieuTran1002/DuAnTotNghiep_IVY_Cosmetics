package com.example.duantotnghiep.repository;

import com.example.duantotnghiep.entity.HinhDang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HinhDangRepository extends JpaRepository<HinhDang, UUID> {
}
