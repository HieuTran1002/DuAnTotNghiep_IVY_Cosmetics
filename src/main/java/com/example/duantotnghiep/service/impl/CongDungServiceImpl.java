package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.CongDung;
import com.example.duantotnghiep.repository.CongDungRepository;
import com.example.duantotnghiep.service.CongDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CongDungServiceImpl implements CongDungService {
    @Autowired
    private CongDungRepository congDungRepository;
    @Override
    public List<CongDung> getAll() {
        return congDungRepository.findAll();
    }

    @Override
    public CongDung add(CongDung congDung) {
        return congDungRepository.save(congDung);
    }

    @Override
    public CongDung update(UUID id, CongDung congDung) {
        CongDung congDung1=congDungRepository.findById(id).orElse(null);
        congDung1.setId(congDung.getId());
        congDung1.setMaCongDung(congDung.getMaCongDung());
        congDung1.setTenConDung(congDung.getTenConDung());
        congDung1.setMoTa(congDung.getMoTa());
        congDung1.setTrangThai(congDung.getTrangThai());
        return congDungRepository.save(congDung1);
    }

    @Override
    public CongDung detail(UUID id) {
        return congDungRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.congDungRepository.deleteById(id);
        return true;
    }
}
