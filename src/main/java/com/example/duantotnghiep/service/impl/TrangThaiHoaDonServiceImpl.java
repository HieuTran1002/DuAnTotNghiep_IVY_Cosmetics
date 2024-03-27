package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.TrangThaiHoaDon;
import com.example.duantotnghiep.repository.TrangThaiHoaDonRepository;
import com.example.duantotnghiep.service.TrangThaiHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrangThaiHoaDonServiceImpl implements TrangThaiHoaDonService {

    @Autowired
    private TrangThaiHoaDonRepository trangThaiHoaDonRepository;

    @Override
    public TrangThaiHoaDon getTrangThaiById(UUID id) {
        Optional<TrangThaiHoaDon> trangThaiOptional = trangThaiHoaDonRepository.findById(id);
        return trangThaiOptional.orElse(null);
    }

    @Override
    public List<TrangThaiHoaDon> getAllTrangThai() {
        return trangThaiHoaDonRepository.findAll();
    }

    @Override
    public TrangThaiHoaDon createTrangThai(TrangThaiHoaDon trangThai) {
        return trangThaiHoaDonRepository.save(trangThai);
    }

    @Override
    public void deleteTrangThai(UUID id) {
        trangThaiHoaDonRepository.deleteById(id);
    }
}


