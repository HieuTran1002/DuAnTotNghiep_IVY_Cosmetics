package com.example.datn.repository;

import com.example.datn.entity.CongDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CongDungRepository extends JpaRepository<CongDung, UUID> {
//    @Query("select p from CongDung p where p.ma = ?1")
//    CongDung findCongDungByMa(String ma);
//
//    @Query("delete from CongDung where ma = ?1")
//    void deleteCongDungByMa(String ma);
}
