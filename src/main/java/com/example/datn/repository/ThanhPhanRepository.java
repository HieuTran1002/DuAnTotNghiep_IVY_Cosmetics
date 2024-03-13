package com.example.datn.repository;

import com.example.datn.entity.ThanhPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThanhPhanRepository extends JpaRepository<ThanhPhan, UUID> {
//    @Query("select p from ThanhPhan p where p.ma = ?1")
//    ThanhPhan findThanhPhanByMa(String ma);
//
//    @Query("delete from ThanhPhan where ma = ?1")
//    void deleteThanhPhanByMa(String ma);
}
