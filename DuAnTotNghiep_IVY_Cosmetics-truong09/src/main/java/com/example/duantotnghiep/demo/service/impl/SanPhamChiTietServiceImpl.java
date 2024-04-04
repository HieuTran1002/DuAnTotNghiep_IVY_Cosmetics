package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.SanPhamChiTietEntity;
import com.example.duantotnghiep.demo.repository.SanPhamChiTietRepository;
import com.example.duantotnghiep.demo.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {
    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;
    @Override
    public List<SanPhamChiTietEntity> getAll() {
        return sanPhamChiTietRepository.findAll();
    }

    @Override
    public SanPhamChiTietEntity add(SanPhamChiTietEntity sanPhamChiTietEntity) {
        return sanPhamChiTietRepository.save(sanPhamChiTietEntity);
    }

    @Override
    public SanPhamChiTietEntity update(UUID id, SanPhamChiTietEntity sanPhamChiTietEntity) {
        SanPhamChiTietEntity sanPhamChiTietEntity1=sanPhamChiTietRepository.findById(id).orElse(null);
        sanPhamChiTietEntity1.setId(sanPhamChiTietEntity.getId());
        sanPhamChiTietEntity1.setSanPhamEntity(sanPhamChiTietEntity.getSanPhamEntity());
        sanPhamChiTietEntity1.setAnhSanPhamEntity(sanPhamChiTietEntity.getAnhSanPhamEntity());
        sanPhamChiTietEntity1.setMauSacEntity(sanPhamChiTietEntity.getMauSacEntity());
        sanPhamChiTietEntity1.setTrangThai(sanPhamChiTietEntity.getTrangThai());
        sanPhamChiTietEntity1.setSoLuongTon(sanPhamChiTietEntity.getSoLuongTon());

        return sanPhamChiTietRepository.save(sanPhamChiTietEntity1);
    }

    @Override
    public SanPhamChiTietEntity detail(UUID id) {
        return sanPhamChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {

        this.sanPhamChiTietRepository.deleteById(id);
        return true;
    }

}
