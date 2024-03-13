package com.example.datn.repository;

import com.example.datn.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    //    Lấy sản phẩm theo mã
//    @Query("select sp from SanPham sp where sp.ma = ?1")
//    SanPham findSanPhamByMa(@Param("ma") String ma);


    //Tìm kiếm theo DanhMuc


}
