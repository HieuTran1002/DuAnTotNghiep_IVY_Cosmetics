package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.KhachHangEntity;
import com.example.duantotnghiep.demo.repository.KhachHangRepository;
import com.example.duantotnghiep.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl  implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Override
    public List<KhachHangEntity> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHangEntity add(KhachHangEntity khachHangEntity) {
        return khachHangRepository.save(khachHangEntity);
    }

    @Override
    public KhachHangEntity update(UUID id, KhachHangEntity khachHangEntity) {
        KhachHangEntity khachHangEntity1=khachHangRepository.findById(id).orElse(null);
        khachHangEntity1.setId(khachHangEntity.getId());
        khachHangEntity1.setAvatar(khachHangEntity.getAvatar());
        khachHangEntity1.setEmail(khachHangEntity.getEmail());
        khachHangEntity1.setTrangThai(khachHangEntity.getTrangThai());
        khachHangEntity1.setMa(khachHangEntity.getMa());
        khachHangEntity1.setGioiTinh(khachHangEntity.getGioiTinh());
        khachHangEntity1.setNgayCapNhat(khachHangEntity.getNgayCapNhat());
        khachHangEntity1.setNgaySinh(khachHangEntity.getNgaySinh());
        khachHangEntity1.setNgayTao(khachHangEntity.getNgayTao());
        khachHangEntity1.setSoDienThoai(khachHangEntity.getSoDienThoai());
        khachHangEntity1.setTen(khachHangEntity.getTen());
        return khachHangRepository.save(khachHangEntity1);
    }

    @Override
    public KhachHangEntity detail(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.khachHangRepository.deleteById(id);
        return true;
    }
}
