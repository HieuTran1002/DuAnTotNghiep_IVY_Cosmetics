package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.ViDiemEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ViDiemService {

    List<ViDiemEntity> getAllViDiems();

    Optional<ViDiemEntity> getViDiemById(UUID id);

    ViDiemEntity createViDiem(ViDiemEntity viDiem);

    ViDiemEntity updateViDiem(UUID id, ViDiemEntity viDiem);

    void deleteViDiem(UUID id);
}
