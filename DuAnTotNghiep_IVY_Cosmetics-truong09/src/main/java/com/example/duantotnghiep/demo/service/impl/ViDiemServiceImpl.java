package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.ViDiemEntity;
import com.example.duantotnghiep.demo.repository.ViDiemRepository;
import com.example.duantotnghiep.demo.service.ViDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ViDiemServiceImpl implements ViDiemService {

    @Autowired
    private ViDiemRepository viDiemRepository;

    @Override
    public List<ViDiemEntity> getAllViDiems() {
        return viDiemRepository.findAll();
    }

    @Override
    public Optional<ViDiemEntity> getViDiemById(UUID id) {
        return viDiemRepository.findById(id);
    }

    @Override
    public ViDiemEntity createViDiem(ViDiemEntity viDiem) {
        return viDiemRepository.save(viDiem);
    }

    @Override
    public ViDiemEntity updateViDiem(UUID id, ViDiemEntity viDiem) {
        viDiem.setId(id);
        return viDiemRepository.save(viDiem);
    }

    @Override
    public void deleteViDiem(UUID id) {
        viDiemRepository.deleteById(id);
    }
}
