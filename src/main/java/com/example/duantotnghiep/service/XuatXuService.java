package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.XuatXu;

import java.util.List;
import java.util.UUID;

public interface XuatXuService {
    List<XuatXu> getAll();
    XuatXu add(XuatXu XuatXu);
    XuatXu update(UUID id, XuatXu XuatXu);
    XuatXu detail(UUID id);
    Boolean delete(UUID id);
}
