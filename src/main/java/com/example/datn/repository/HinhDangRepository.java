package com.example.datn.repository;

import com.example.datn.entity.HinhDang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HinhDangRepository extends JpaRepository<HinhDang, UUID> {
//    @Query("select p from HinhDang p where p.ma = ?1")
//    HinhDang findHinhDangByMa(String ma);
//
//    @Query("delete from HinhDang where ma = ?1")
//    void deleteHinhDangByMa(String ma);
}
