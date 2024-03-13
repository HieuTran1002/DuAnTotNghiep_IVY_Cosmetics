package com.example.datn.service.impl;

import com.example.datn.entity.SanPham;
import com.example.datn.repository.SanPhamRepository;
import com.example.datn.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham detail(UUID id) {
        Optional<SanPham> sp = sanPhamRepository.findById(id);
        return sp.orElse(null);
    }

    @Override
    public void create(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void update(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void remove(UUID id) {
        sanPhamRepository.deleteById(id);
    }
}
