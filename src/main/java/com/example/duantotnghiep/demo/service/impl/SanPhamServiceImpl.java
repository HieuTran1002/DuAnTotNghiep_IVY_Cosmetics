package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.SanPhamEntity;
import com.example.duantotnghiep.demo.repository.SanPhamRepository;
import com.example.duantotnghiep.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPhamEntity> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPhamEntity add(SanPhamEntity sanPhamEntity) {
        return sanPhamRepository.save(sanPhamEntity);
    }

    @Override
    public SanPhamEntity update(UUID id, SanPhamEntity sanPhamEntity) {
        SanPhamEntity sanPhamEntity1=sanPhamRepository.findById(id).orElse(null);
        sanPhamEntity1.setId(sanPhamEntity.getId());
        sanPhamEntity1.setCongDungEntity(sanPhamEntity.getCongDungEntity());
        sanPhamEntity1.setGiamGiaEntity(sanPhamEntity.getGiamGiaEntity());
        sanPhamEntity1.setDoHot(sanPhamEntity.getDoHot());
        sanPhamEntity1.setGiaBan(sanPhamEntity.getGiaBan());
        sanPhamEntity1.setHinhDangEntity(sanPhamEntity.getHinhDangEntity());
        sanPhamEntity1.setTrangThai(sanPhamEntity.getTrangThai());
        sanPhamEntity1.setThanhPhanEntity(sanPhamEntity.getThanhPhanEntity());
        sanPhamEntity1.setXuatXuEntity(sanPhamEntity.getXuatXuEntity());
        sanPhamEntity1.setThuongHieuEntity(sanPhamEntity.getThuongHieuEntity());
        sanPhamEntity1.setMa(sanPhamEntity.getMa());
        sanPhamEntity1.setTen(sanPhamEntity.getTen());
        sanPhamEntity1.setGiaNhap(sanPhamEntity.getGiaNhap());
        sanPhamEntity1.setGiaSauKhuyenMai(sanPhamEntity.getGiaSauKhuyenMai());
        sanPhamEntity1.setNgayNhap(sanPhamEntity.getNgayNhap());
        sanPhamEntity1.setMoTa(sanPhamEntity.getMoTa());
        return sanPhamRepository.save(sanPhamEntity1);
    }

    @Override
    public SanPhamEntity detail(UUID id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.sanPhamRepository.deleteById(id);
        return true;
    }
}
