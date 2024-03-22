package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.ThuongHieuEntity;
import com.example.duantotnghiep.demo.entity.XuatXuEntity;

import java.util.List;
import java.util.UUID;

public interface ThuongHieuService {
    List<ThuongHieuEntity> getAll();
    ThuongHieuEntity add(ThuongHieuEntity thuongHieuEntity);
    ThuongHieuEntity update(UUID id, ThuongHieuEntity thuongHieuEntity);
    ThuongHieuEntity detail(UUID id);
    Boolean delete(UUID id);
}
