package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.DanhMucEntity;
import com.example.duantotnghiep.demo.entity.GiamGiaEntity;

import java.util.List;
import java.util.UUID;

public interface DanhMucService {
    List<DanhMucEntity> getAll();
    DanhMucEntity add(DanhMucEntity danhMucEntity);
    DanhMucEntity update(UUID id, DanhMucEntity danhMucEntity);
    DanhMucEntity detail(UUID id);
    Boolean delete(UUID id);
}
