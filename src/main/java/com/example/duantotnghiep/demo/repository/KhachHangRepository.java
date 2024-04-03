package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.KhachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface KhachHangRepository extends JpaRepository<KhachHangEntity, UUID> {

}
