package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.DanhMucEntity;
import com.example.duantotnghiep.demo.entity.XuatXuEntity;
import com.example.duantotnghiep.demo.repository.DanhMucRepository;
import com.example.duantotnghiep.demo.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    private DanhMucRepository danhMucRepository;

    @Override
    public List<DanhMucEntity> getAll() {
        return danhMucRepository.findAll();
    }

    @Override
    public DanhMucEntity add(DanhMucEntity danhMucEntity) {
        return danhMucRepository.save(danhMucEntity);
    }

    @Override
    public DanhMucEntity update(UUID id, DanhMucEntity danhMucEntity) {
        DanhMucEntity danhMucEntity1=danhMucRepository.findById(id).orElse(null);
        danhMucEntity1.setId(danhMucEntity.getId());
        danhMucEntity1.setMa(danhMucEntity.getMa());
        danhMucEntity1.setTen(danhMucEntity.getTen());
        danhMucEntity1.setSanPhamEntity(danhMucEntity.getSanPhamEntity());
        danhMucEntity1.setTrangThai(danhMucEntity.getTrangThai());
        return danhMucRepository.save(danhMucEntity1);
    }

    @Override
    public DanhMucEntity detail(UUID id) {
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        return null;
    }
}
