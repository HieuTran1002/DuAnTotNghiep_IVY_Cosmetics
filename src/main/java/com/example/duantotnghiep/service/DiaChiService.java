package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.DiaChi;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DiaChiService {

    DiaChi createDiaChi(DiaChi diaChi);

    List<DiaChi> getAllDiaChis();

    Optional<DiaChi> getDiaChiById(UUID id);

    DiaChi updateDiaChi(UUID id, DiaChi diaChi);

    void deleteDiaChi(UUID id);
}
