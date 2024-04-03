package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.HinhDang;
import com.example.duantotnghiep.repository.HinhDangRepository;
import com.example.duantotnghiep.service.HinhDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HinhDangServiceImpl implements HinhDangService {
    @Autowired
    private HinhDangRepository hinhDangRepository;
    @Override
    public List<HinhDang> getAll() {
        return hinhDangRepository.findAll();
    }

    @Override
    public HinhDang add(HinhDang HinhDang) {
        return hinhDangRepository.save(HinhDang);
    }

    @Override
    public HinhDang update(UUID id, HinhDang HinhDang) {
        HinhDang HinhDang1=hinhDangRepository.findById(id).orElse(null);
        HinhDang1.setId(HinhDang.getId());
        HinhDang1.setMa(HinhDang.getMa());
        HinhDang1.setTen(HinhDang.getTen());
        HinhDang1.setMoTa(HinhDang.getMoTa());
        HinhDang1.setTrangThai(HinhDang.getTrangThai());
        return hinhDangRepository.save(HinhDang1);
    }

    @Override
    public HinhDang detail(UUID id) {
        return hinhDangRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.hinhDangRepository.deleteById(id);
        return true;
    }
}
