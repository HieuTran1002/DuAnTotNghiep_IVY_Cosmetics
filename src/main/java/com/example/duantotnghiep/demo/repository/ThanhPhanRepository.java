package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ThanhPhanRepository extends JpaRepository<ThanhPhanEntity, UUID> {
}
