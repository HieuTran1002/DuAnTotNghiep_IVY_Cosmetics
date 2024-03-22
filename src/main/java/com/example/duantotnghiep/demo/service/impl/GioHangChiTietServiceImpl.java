package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.GioHangChiTietEntity;
import com.example.duantotnghiep.demo.repository.GioHangChiTietRepository;
import com.example.duantotnghiep.demo.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;
    @Override
    public List<GioHangChiTietEntity> getAll() {
        return gioHangChiTietRepository.findAll();
    }

    @Override
    public GioHangChiTietEntity add(GioHangChiTietEntity gioHangChiTietEntity) {
        return gioHangChiTietRepository.save(gioHangChiTietEntity);
    }

    @Override
    public GioHangChiTietEntity update(UUID id, GioHangChiTietEntity gioHangChiTietEntity) {
        GioHangChiTietEntity gioHangChiTietEntity1=gioHangChiTietRepository.findById(id).orElse(null);
        gioHangChiTietEntity1.setId(gioHangChiTietEntity.getId());
        gioHangChiTietEntity1.setGioHang(gioHangChiTietEntity.getGioHang());
        gioHangChiTietEntity1.setSanPhamChiTietEntity(gioHangChiTietEntity.getSanPhamChiTietEntity());
        gioHangChiTietEntity1.setDonGia(gioHangChiTietEntity.getDonGia());
        gioHangChiTietEntity1.setGhiChu(gioHangChiTietEntity.getGhiChu());
        gioHangChiTietEntity1.setDonGiaKhiGiam(gioHangChiTietEntity.getDonGiaKhiGiam());
        gioHangChiTietEntity1.setSoLuong(gioHangChiTietEntity.getSoLuong());
        gioHangChiTietEntity1.setTrangThai(gioHangChiTietEntity.getTrangThai());
        return gioHangChiTietRepository.save(gioHangChiTietEntity1);
    }

    @Override
    public GioHangChiTietEntity detail(UUID id) {
        return gioHangChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.gioHangChiTietRepository.deleteById(id);
        return true;
    }
}
