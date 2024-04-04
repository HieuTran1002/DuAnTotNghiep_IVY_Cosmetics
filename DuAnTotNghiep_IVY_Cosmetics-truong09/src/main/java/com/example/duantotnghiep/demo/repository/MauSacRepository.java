package com.example.duantotnghiep.demo.repository;

import com.example.duantotnghiep.demo.entity.MauSacEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSacEntity,UUID> {

}
