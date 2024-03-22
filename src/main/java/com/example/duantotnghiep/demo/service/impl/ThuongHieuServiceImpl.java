package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.ThuongHieuEntity;
import com.example.duantotnghiep.demo.entity.XuatXuEntity;
import com.example.duantotnghiep.demo.repository.ThuongHieuRepository;
import com.example.duantotnghiep.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;
    @Override
    public List<ThuongHieuEntity> getAll() {
        return thuongHieuRepository.findAll();
    }

    @Override
    public ThuongHieuEntity add(ThuongHieuEntity thuongHieuEntity) {
        return thuongHieuRepository.save(thuongHieuEntity);
    }

    @Override
    public ThuongHieuEntity update(UUID id, ThuongHieuEntity thuongHieuEntity) {
        ThuongHieuEntity thuongHieuEntity1=thuongHieuRepository.findById(id).orElse(null);
        thuongHieuEntity1.setId(thuongHieuEntity.getId());
        thuongHieuEntity1.setMa(thuongHieuEntity.getMa());
        thuongHieuEntity1.setTen(thuongHieuEntity.getTen());
        thuongHieuEntity1.setMoTa(thuongHieuEntity.getMoTa());
        thuongHieuEntity1.setNgayTao(thuongHieuEntity.getNgayTao());
        thuongHieuEntity1.setNgayCapNhat(thuongHieuEntity.getNgayCapNhat());
        thuongHieuEntity1.setTrangThai(thuongHieuEntity.getTrangThai());
        return thuongHieuRepository.save(thuongHieuEntity1);
    }

    @Override
    public ThuongHieuEntity detail(UUID id) {
        return thuongHieuRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.thuongHieuRepository.deleteById(id);
        return true;
    }
}
