package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.KhachHang;
import com.example.duantotnghiep.repository.KhachHangRepository;
import com.example.duantotnghiep.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public KhachHang createKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public List<KhachHang> getAllKhachHangs() {
        return khachHangRepository.findAll();
    }

    @Override
    public Optional<KhachHang> getKhachHangById(UUID id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public KhachHang updateKhachHang(UUID id, KhachHang khachHang) {
        Optional<KhachHang> optionalKhachHang = khachHangRepository.findById(id);
        if (optionalKhachHang.isPresent()) {
            KhachHang existingKhachHang = optionalKhachHang.get();
            return khachHangRepository.save(existingKhachHang);
        } else {
            return null;
        }
    }

    @Override
    public void deleteKhachHang(UUID id) {
        khachHangRepository.deleteById(id);
    }
}
