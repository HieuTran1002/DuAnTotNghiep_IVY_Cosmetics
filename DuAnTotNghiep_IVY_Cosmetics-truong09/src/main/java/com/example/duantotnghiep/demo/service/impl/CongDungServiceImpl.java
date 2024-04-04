package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.CongDungEntity;
import com.example.duantotnghiep.demo.repository.CongDungRepository;
import com.example.duantotnghiep.demo.service.CongDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CongDungServiceImpl implements CongDungService {
    @Autowired
    private CongDungRepository congDungRepository;
    @Override
    public List<CongDungEntity> getAll() {
        return congDungRepository.findAll();
    }

    @Override
    public CongDungEntity add(CongDungEntity congDungEntity) {
        return congDungRepository.save(congDungEntity);
    }

    @Override
    public CongDungEntity update(UUID id, CongDungEntity congDungEntity) {
        CongDungEntity congDungEntity1=congDungRepository.findById(id).orElse(null);
        congDungEntity1.setId(congDungEntity.getId());
        congDungEntity1.setMaCongDung(congDungEntity.getMaCongDung());
        congDungEntity1.setTenConDung(congDungEntity.getTenConDung());
        congDungEntity1.setMoTa(congDungEntity.getMoTa());
        congDungEntity1.setTrangThai(congDungEntity.getTrangThai());
        return congDungRepository.save(congDungEntity1);
    }

    @Override
    public CongDungEntity detail(UUID id) {
        return congDungRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.congDungRepository.deleteById(id);
        return true;
    }
}
