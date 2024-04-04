package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.ThanhPhanEntity;
import com.example.duantotnghiep.demo.repository.ThanhPhanRepository;
import com.example.duantotnghiep.demo.service.ThanhPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ThanhPhanServiceImpl implements ThanhPhanService {
    @Autowired
    private ThanhPhanRepository thanhPhanRepository;
    @Override
    public List<ThanhPhanEntity> getAll() {
        return thanhPhanRepository.findAll();
    }

    @Override
    public ThanhPhanEntity add(ThanhPhanEntity thanhPhanEntity) {
        return thanhPhanRepository.save(thanhPhanEntity);
    }

    @Override
    public ThanhPhanEntity update(UUID id, ThanhPhanEntity thanhPhanEntity) {
        ThanhPhanEntity thanhPhanEntity1=thanhPhanRepository.findById(id).orElse(null);
        thanhPhanEntity1.setId(thanhPhanEntity.getId());
        thanhPhanEntity1.setMaThanhPhan(thanhPhanEntity.getMaThanhPhan());
        thanhPhanEntity1.setTenThanhPhan(thanhPhanEntity.getTenThanhPhan());
        thanhPhanEntity1.setMoTa(thanhPhanEntity.getMoTa());
        thanhPhanEntity1.setTrangThai(thanhPhanEntity.getTrangThai());
        return thanhPhanRepository.save(thanhPhanEntity1);
    }

    @Override
    public ThanhPhanEntity detail(UUID id) {
        return thanhPhanRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.thanhPhanRepository.deleteById(id);
        return true;
    }
}
