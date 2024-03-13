package com.example.datn.repository;

import com.example.datn.entity.XuatXu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface XuatXuRepository extends JpaRepository<XuatXu, UUID> {
//    @Query("select p from XuatXu p where p.ma = ?1")
//    XuatXu findXuatXuByMa(String ma);
//
//    @Query("delete from XuatXu where ma = ?1")
//    void deleteXuatXuByMa(String ma);
}
