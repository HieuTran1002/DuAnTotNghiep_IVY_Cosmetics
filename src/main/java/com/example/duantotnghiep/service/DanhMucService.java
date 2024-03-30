package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.DanhMuc;

import java.util.List;
import java.util.UUID;

public interface DanhMucService {
    List<DanhMuc> getAll();
    DanhMuc add(DanhMuc DanhMuc);
    DanhMuc update(UUID id, DanhMuc DanhMuc);
    DanhMuc detail(UUID id);
    Boolean delete(UUID id);
}
