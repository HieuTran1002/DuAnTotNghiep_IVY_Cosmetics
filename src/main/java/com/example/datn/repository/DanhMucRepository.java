package com.example.datn.repository;

import com.example.datn.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, UUID> {

//    @Query("select p from DanhMuc p where p.ma = ?1")
//    List<DanhMuc> getSanPhamByMaSanPham(String ma);

}
