package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.ThanhPhan;
import com.example.duantotnghiep.repository.ThanhPhanRepository;
import com.example.duantotnghiep.service.ThanhPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ThanhPhanServiceImpl implements ThanhPhanService {
    @Autowired
    private ThanhPhanRepository thanhPhanRepository;
    @Override
    public List<ThanhPhan> getAll() {
        return thanhPhanRepository.findAll();
    }

    @Override
    public ThanhPhan add(ThanhPhan thanhPhan) {
        return thanhPhanRepository.save(thanhPhan);
    }

    @Override
    public ThanhPhan update(UUID id, ThanhPhan thanhPhan) {
        ThanhPhan thanhPhan1=thanhPhanRepository.findById(id).orElse(null);
        thanhPhan1.setId(thanhPhan.getId());
        thanhPhan1.setMaThanhPhan(thanhPhan.getMaThanhPhan());
        thanhPhan1.setTenThanhPhan(thanhPhan.getTenThanhPhan());
        thanhPhan1.setMoTa(thanhPhan.getMoTa());
        thanhPhan1.setTrangThai(thanhPhan.getTrangThai());
        return thanhPhanRepository.save(thanhPhan1);
    }

    @Override
    public ThanhPhan detail(UUID id) {
        return thanhPhanRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.thanhPhanRepository.deleteById(id);
        return true;
    }
}
