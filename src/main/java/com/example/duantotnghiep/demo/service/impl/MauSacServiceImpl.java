package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.MauSacEntity;
import com.example.duantotnghiep.demo.repository.MauSacRepository;
import com.example.duantotnghiep.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;
    @Override
    public List<MauSacEntity> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSacEntity add(MauSacEntity mauSacEntity) {
        return mauSacRepository.save(mauSacEntity);
    }


    @Override
    public MauSacEntity update(UUID id, MauSacEntity mauSacEntity) {
        MauSacEntity mauSacEntity1=mauSacRepository.findById(id).orElse(null);
        mauSacEntity1.setId(mauSacEntity.getId());
        mauSacEntity1.setMaMauSac(mauSacEntity.getMaMauSac());
        mauSacEntity1.setTenMauSac(mauSacEntity.getTenMauSac());
        mauSacEntity1.setTrangThai(mauSacEntity.getTrangThai());
        return mauSacRepository.save(mauSacEntity1);
    }

    @Override
    public MauSacEntity detail(UUID id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.mauSacRepository.deleteById(id);
        return true;
    }
}
