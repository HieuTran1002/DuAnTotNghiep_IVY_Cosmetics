package com.example.duantotnghiep.repository;

import com.example.duantotnghiep.entity.ThanhPhan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ThanhPhanRepository extends JpaRepository<ThanhPhan, UUID> {
}
