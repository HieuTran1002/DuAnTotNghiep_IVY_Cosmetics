package com.example.duantotnghiep.demo.service;

import com.example.duantotnghiep.demo.entity.CongDungEntity;
import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;

import java.util.List;
import java.util.UUID;

public interface CongDungService {
    List<CongDungEntity> getAll();
    CongDungEntity add(CongDungEntity congDungEntity);
    CongDungEntity update(UUID id, CongDungEntity congDungEntity);
    CongDungEntity detail(UUID id);
    Boolean delete(UUID id);
}
