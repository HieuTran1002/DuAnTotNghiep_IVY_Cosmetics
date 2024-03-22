package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.ThuongHieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieuEntity, UUID> {
}
