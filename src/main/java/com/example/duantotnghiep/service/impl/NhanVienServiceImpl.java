package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.NhanVien;
import com.example.duantotnghiep.repository.NhanVienRepository;
import com.example.duantotnghiep.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public NhanVien createNhanVien(NhanVien nhanVien) {
        return null;
    }

    @Override
    public List<NhanVien> getAllNhanViens() {
        return null;
    }

    @Override
    public Optional<NhanVien> getNhanVienById(UUID id) {
        return Optional.empty();
    }

    @Override
    public NhanVien updateNhanVien(UUID id, NhanVien nhanVien) {
        return null;
    }

    @Override
    public void deleteNhanVien(UUID id) {

    }
}
