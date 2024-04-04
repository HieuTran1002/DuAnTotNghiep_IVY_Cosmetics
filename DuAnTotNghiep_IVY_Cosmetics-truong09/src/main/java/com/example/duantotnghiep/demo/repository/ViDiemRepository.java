package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.ViDiemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ViDiemRepository extends JpaRepository<ViDiemEntity, UUID> {
}
