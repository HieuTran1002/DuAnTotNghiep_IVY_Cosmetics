package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.HinhDang;

import java.util.List;
import java.util.UUID;

public interface HinhDangService {
    List<HinhDang> getAll();
    HinhDang add(HinhDang hinhDang);
    HinhDang update(UUID id, HinhDang hinhDang);
    HinhDang detail(UUID id);
    Boolean delete(UUID id);
}
