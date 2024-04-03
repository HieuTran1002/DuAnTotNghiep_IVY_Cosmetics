package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.TaiKhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity, UUID> {

    TaiKhoanEntity findByUserName(String userName);
}
