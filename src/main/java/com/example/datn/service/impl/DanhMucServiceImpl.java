package com.example.datn.service.impl;

import com.example.datn.entity.DanhMuc;
import com.example.datn.repository.DanhMucRepository;
import com.example.datn.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DanhMucServiceImpl implements DanhMucService {

    @Autowired
    private DanhMucRepository danhMucRepository;

    @Override
    public List<DanhMuc> getAll() {
        return danhMucRepository.findAll();
    }

    @Override
    public DanhMuc detail(UUID id) {
        Optional<DanhMuc> ds = danhMucRepository.findById(id);
        return ds.orElse(null);
    }

    @Override
    public void create(DanhMuc danhMuc) {
        danhMucRepository.save(danhMuc);
    }

    @Override
    public void update(DanhMuc danhMuc) {
        danhMucRepository.save(danhMuc);
    }

    @Override
    public void remove(UUID id) {
        danhMucRepository.deleteById(id);
    }
}
