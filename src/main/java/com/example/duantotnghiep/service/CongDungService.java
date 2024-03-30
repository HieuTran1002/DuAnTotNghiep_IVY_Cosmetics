package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.CongDung;

import java.util.List;
import java.util.UUID;

public interface CongDungService {
    List<CongDung> getAll();
    CongDung add(CongDung CongDung);
    CongDung update(UUID id, CongDung CongDung);
    CongDung detail(UUID id);
    Boolean delete(UUID id);
}
