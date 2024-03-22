package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;
import com.example.duantotnghiep.demo.entity.XuatXuEntity;

import java.util.List;
import java.util.UUID;

public interface XuatXuService {
    List<XuatXuEntity> getAll();
    XuatXuEntity add(XuatXuEntity xuatXuEntity);
    XuatXuEntity update(UUID id, XuatXuEntity xuatXuEntity);
    XuatXuEntity detail(UUID id);
    Boolean delete(UUID id);
}
