package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.AnhSanPhamEntity;
import com.example.duantotnghiep.demo.repository.AnhSanPhamRepository;
import com.example.duantotnghiep.demo.service.AnhSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnhSanPhamSerivceImpl implements AnhSanPhamService {
    @Autowired
    private AnhSanPhamRepository anhSanPhamRepository;
    @Override
    public List<AnhSanPhamEntity> getAll() {
        return anhSanPhamRepository.findAll();
    }

    @Override
    public AnhSanPhamEntity add(AnhSanPhamEntity anhSanPhamEntity) {
        return anhSanPhamRepository.save(anhSanPhamEntity);
    }

    @Override
    public AnhSanPhamEntity update(UUID id, AnhSanPhamEntity anhSanPhamEntity) {
        AnhSanPhamEntity anhSanPhamEntity1=anhSanPhamRepository.findById(id).orElse(null);
        anhSanPhamEntity1.setMaAnhSanPham(anhSanPhamEntity.getMaAnhSanPham());
        anhSanPhamEntity1.setTenAnhSanPham(anhSanPhamEntity.getTenAnhSanPham());
        anhSanPhamEntity1.setId(anhSanPhamEntity.getId());
        anhSanPhamEntity1.setTrangThai(anhSanPhamEntity.getTrangThai());
        return anhSanPhamRepository.save(anhSanPhamEntity1);
    }

    @Override
    public AnhSanPhamEntity detail(UUID id) {
        return anhSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.anhSanPhamRepository.deleteById(id);
        return true;
    }
}
