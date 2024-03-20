package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.TaiKhoan;
import com.example.duantotnghiep.repository.TaiKhoanRepository;
import com.example.duantotnghiep.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public TaiKhoan createTaiKhoan(TaiKhoan taiKhoan) {
        return taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public List<TaiKhoan> getAllTaiKhoans() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public Optional<TaiKhoan> getTaiKhoanById(UUID id) {
        return taiKhoanRepository.findById(id);
    }

    @Override
    public TaiKhoan updateTaiKhoan(UUID id, TaiKhoan taiKhoan) {
        Optional<TaiKhoan> optionalTaiKhoan = taiKhoanRepository.findById(id);
        if (optionalTaiKhoan.isPresent()) {
            TaiKhoan existingTaiKhoan = optionalTaiKhoan.get();
            return taiKhoanRepository.save(existingTaiKhoan);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTaiKhoan(UUID id) {
        taiKhoanRepository.deleteById(id);
    }
}
