package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.TrangThaiHoaDon;

import java.util.List;
import java.util.UUID;

public interface TrangThaiHoaDonService {

    TrangThaiHoaDon getTrangThaiById(UUID id);

    List<TrangThaiHoaDon> getAllTrangThai();

    TrangThaiHoaDon createTrangThai(TrangThaiHoaDon trangThai);

    void deleteTrangThai(UUID id);

}
