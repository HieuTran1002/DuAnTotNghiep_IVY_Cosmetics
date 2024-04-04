package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.MauSacEntity;
import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSacEntity> getAll();
    MauSacEntity add(MauSacEntity mauSacEntity);
    MauSacEntity update(UUID id, MauSacEntity mauSacEntity);
    MauSacEntity detail(UUID id);
    Boolean delete(UUID id);
}
