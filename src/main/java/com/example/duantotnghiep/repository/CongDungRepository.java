package com.example.duantotnghiep.repository;

import com.example.duantotnghiep.entity.CongDung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CongDungRepository extends JpaRepository<CongDung, UUID> {
}
