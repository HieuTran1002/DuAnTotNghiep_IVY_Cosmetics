package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.CongDungEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CongDungRepository extends JpaRepository<CongDungEntity, UUID> {
}
