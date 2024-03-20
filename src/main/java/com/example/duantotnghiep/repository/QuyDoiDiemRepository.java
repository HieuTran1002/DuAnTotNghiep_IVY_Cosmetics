package com.example.duantotnghiep.repository;

import com.example.duantotnghiep.entity.QuyDoiDiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface QuyDoiDiemRepository extends JpaRepository<QuyDoiDiem, UUID> {
}
