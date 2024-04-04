package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.GiamGiaEntity;
import com.example.duantotnghiep.demo.entity.XuatXuEntity;
import com.example.duantotnghiep.demo.repository.GiamGiaRepository;
import com.example.duantotnghiep.demo.service.GiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GiamGiaServiceImpl implements GiamGiaService {
    @Autowired
    private GiamGiaRepository giamGiaRepository;
    @Override
    public List<GiamGiaEntity> getAll() {
        return giamGiaRepository.findAll();
    }

    @Override
    public GiamGiaEntity add(GiamGiaEntity giamGiaEntity) {
        return giamGiaRepository.save(giamGiaEntity);
    }

    @Override
    public GiamGiaEntity update(UUID id, GiamGiaEntity giamGiaEntity) {
        GiamGiaEntity giamGiaEntity1=giamGiaRepository.findById(id).orElse(null);
        giamGiaEntity1.setId(giamGiaEntity.getId());
        giamGiaEntity1.setMa(giamGiaEntity.getMa());
        giamGiaEntity1.setTen(giamGiaEntity.getTen());
        giamGiaEntity1.setGiaGiam(giamGiaEntity.getGiaGiam());
        giamGiaEntity1.setDonGia(giamGiaEntity.getDonGia());
        giamGiaEntity1.setHinhThucGiam(giamGiaEntity.getHinhThucGiam());
        giamGiaEntity1.setNgayBatDau(giamGiaEntity.getNgayBatDau());
        giamGiaEntity1.setNgayKetThuc(giamGiaEntity.getNgayKetThuc());
        giamGiaEntity1.setTrangThai(giamGiaEntity.getTrangThai());
        return giamGiaRepository.save(giamGiaEntity1);
    }

    @Override
    public GiamGiaEntity detail(UUID id) {
        return giamGiaRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.giamGiaRepository.deleteById(id);
        return true;
    }
}
