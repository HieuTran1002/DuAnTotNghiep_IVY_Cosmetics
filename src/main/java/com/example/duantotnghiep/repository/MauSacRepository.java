package com.example.duantotnghiep.repository;

import com.example.duantotnghiep.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac,UUID> {

}
