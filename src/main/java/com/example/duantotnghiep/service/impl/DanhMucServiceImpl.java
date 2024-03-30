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
    public DanhMuc add(DanhMuc DanhMuc) {
        return danhMucRepository.save(DanhMuc);
    }

    @Override
    public DanhMuc update(UUID id, DanhMuc DanhMuc) {
        DanhMuc DanhMuc1=danhMucRepository.findById(id).orElse(null);
        DanhMuc1.setId(DanhMuc.getId());
        DanhMuc1.setMa(DanhMuc.getMa());
        DanhMuc1.setTen(DanhMuc.getTen());
        DanhMuc1.setSanPhamList(DanhMuc.getSanPhamList());
        DanhMuc1.setTrangThai(DanhMuc.getTrangThai());
        return danhMucRepository.save(DanhMuc1);
    }

    @Override
    public DanhMuc detail(UUID id) {
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        return null;
    }
}
