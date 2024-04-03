package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.DanhMuc;
import com.example.duantotnghiep.repository.DanhMucRepository;
import com.example.duantotnghiep.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public DanhMuc add(DanhMuc danhMuc) {
        return danhMucRepository.save(danhMuc);
    }

    @Override
    public DanhMuc update(UUID id, DanhMuc danhMuc) {
        DanhMuc existingDanhMuc = danhMucRepository.findById(id).orElse(null);
        if (existingDanhMuc != null) {
            existingDanhMuc.setMa(danhMuc.getMa());
            existingDanhMuc.setTen(danhMuc.getTen());
            existingDanhMuc.setSanPhamList(danhMuc.getSanPhamList());
            existingDanhMuc.setTrangThai(danhMuc.getTrangThai());
            return danhMucRepository.save(existingDanhMuc);
        }
        return null;
    }

    @Override
    public DanhMuc detail(UUID id) {
        return danhMucRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        if (danhMucRepository.existsById(id)) {
            danhMucRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
