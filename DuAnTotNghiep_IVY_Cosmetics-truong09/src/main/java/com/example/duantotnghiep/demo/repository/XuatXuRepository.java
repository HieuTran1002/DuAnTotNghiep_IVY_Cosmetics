package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.XuatXuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface XuatXuRepository extends JpaRepository<XuatXuEntity, UUID> {
}
