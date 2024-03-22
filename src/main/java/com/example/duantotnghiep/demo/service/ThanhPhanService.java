package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;

import java.util.List;
import java.util.UUID;

public interface ThanhPhanService {
    List<ThanhPhanEntity> getAll();
    ThanhPhanEntity add(ThanhPhanEntity thanhPhanEntity);
    ThanhPhanEntity update(UUID id, ThanhPhanEntity thanhPhanEntity);
    ThanhPhanEntity detail(UUID id);
    Boolean delete(UUID id);
}
