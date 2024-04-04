package com.example.duantotnghiep.demo.service.impl;


import com.example.duantotnghiep.demo.entity.HinhDangEntity;
import com.example.duantotnghiep.demo.entity.XuatXuEntity;
import com.example.duantotnghiep.demo.repository.HinhDangRepository;
import com.example.duantotnghiep.demo.service.HinhDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HinhDangServiceImpl implements HinhDangService {
    @Autowired
    private HinhDangRepository hinhDangRepository;
    @Override
    public List<HinhDangEntity> getAll() {
        return hinhDangRepository.findAll();
    }

    @Override
    public HinhDangEntity add(HinhDangEntity hinhDangEntity) {
        return hinhDangRepository.save(hinhDangEntity);
    }

    @Override
    public HinhDangEntity update(UUID id, HinhDangEntity hinhDangEntity) {
        HinhDangEntity hinhDangEntity1=hinhDangRepository.findById(id).orElse(null);
        hinhDangEntity1.setId(hinhDangEntity.getId());
        hinhDangEntity1.setMa(hinhDangEntity.getMa());
        hinhDangEntity1.setTen(hinhDangEntity.getTen());
        hinhDangEntity1.setMoTa(hinhDangEntity.getMoTa());
        hinhDangEntity1.setTrangThai(hinhDangEntity.getTrangThai());
        return hinhDangRepository.save(hinhDangEntity1);
    }

    @Override
    public HinhDangEntity detail(UUID id) {
        return hinhDangRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.hinhDangRepository.deleteById(id);
        return true;
    }
}
