package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.MauSac;
import com.example.duantotnghiep.repository.MauSacRepository;
import com.example.duantotnghiep.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;
    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac add(MauSac mauSac) {
        return mauSacRepository.save(mauSac);
    }


    @Override
    public MauSac update(UUID id, MauSac mauSac) {
        MauSac mauSac1=mauSacRepository.findById(id).orElse(null);
        mauSac1.setId(mauSac.getId());
        mauSac1.setMaMauSac(mauSac.getMaMauSac());
        mauSac1.setTenMauSac(mauSac.getTenMauSac());
        mauSac1.setTrangThai(mauSac.getTrangThai());
        return mauSacRepository.save(mauSac1);
    }

    @Override
    public MauSac detail(UUID id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.mauSacRepository.deleteById(id);
        return true;
    }
}
