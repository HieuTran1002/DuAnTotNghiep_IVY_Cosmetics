package com.example.datn.repository;

import com.example.datn.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, UUID> {
//    @Query("select p from ThuongHieu p where p.ma = ?1")
//    ThuongHieu findThuongHieuByMa(String ma);
//
//    @Query("delete from ThanhPhan where ma = ?1")
//    void deleteThuongHieuByMa(String ma);
}
