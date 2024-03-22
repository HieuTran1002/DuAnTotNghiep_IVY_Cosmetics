package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.GiamGiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GiamGiaRepository extends JpaRepository<GiamGiaEntity, UUID> {
}
