package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.AnhSanPham;
import com.example.duantotnghiep.repository.AnhSanPhamRepository;
import com.example.duantotnghiep.service.AnhSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnhSanPhamSerivceImpl implements AnhSanPhamService {
    @Autowired
    private AnhSanPhamRepository anhSanPhamRepository;
    @Override
    public List<AnhSanPham> getAll() {
        return anhSanPhamRepository.findAll();
    }

    @Override
    public AnhSanPham add(AnhSanPham anhSanPham) {
        return anhSanPhamRepository.save(anhSanPham);
    }

    @Override
    public AnhSanPham update(UUID id, AnhSanPham anhSanPham) {
        AnhSanPham anhSanPham1=anhSanPhamRepository.findById(id).orElse(null);
        anhSanPham1.setMaAnhSanPham(anhSanPham.getMaAnhSanPham());
        anhSanPham1.setTenAnhSanPham(anhSanPham.getTenAnhSanPham());
        anhSanPham1.setId(anhSanPham.getId());
        anhSanPham1.setTrangThai(anhSanPham.getTrangThai());
        return anhSanPhamRepository.save(anhSanPham1);
    }

    @Override
    public AnhSanPham detail(UUID id) {
        return anhSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.anhSanPhamRepository.deleteById(id);
        return true;
    }
}
