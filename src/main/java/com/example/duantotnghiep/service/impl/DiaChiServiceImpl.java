package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.DiaChi;
import com.example.duantotnghiep.repository.DiaChiRepository;
import com.example.duantotnghiep.service.DiaChiService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class DiaChiServiceImpl implements DiaChiService {

    @Autowired
    private DiaChiRepository diaChiRepository;

    @Override
    public DiaChi createDiaChi(DiaChi diaChi) {
        return diaChiRepository.save(diaChi);
    }

    @Override
    public List<DiaChi> getAllDiaChis() {
        return diaChiRepository.findAll();
    }

    @Override
    public Optional<DiaChi> getDiaChiById(UUID id) {
        return diaChiRepository.findById(id);
    }

    @Override
    public DiaChi updateDiaChi(UUID id, DiaChi diaChi) {
        Optional<DiaChi> optionalDiaChi = diaChiRepository.findById(id);
        if (optionalDiaChi.isPresent()) {
            DiaChi existingDiaChi = optionalDiaChi.get();
            // Update existingDiaChi fields here
            return diaChiRepository.save(existingDiaChi);
        } else {
            return null;
        }
    }

    @Override
    public void deleteDiaChi(UUID id) {
        diaChiRepository.deleteById(id);
    }
}
