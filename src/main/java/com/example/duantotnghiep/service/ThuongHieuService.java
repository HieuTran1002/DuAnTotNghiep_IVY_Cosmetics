package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.ThuongHieu;

import java.util.List;
import java.util.UUID;

public interface ThuongHieuService {
    List<ThuongHieu> getAll();
    ThuongHieu add(ThuongHieu ThuongHieu);
    ThuongHieu update(UUID id, ThuongHieu ThuongHieu);
    ThuongHieu detail(UUID id);
    Boolean delete(UUID id);
}
