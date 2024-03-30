package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.GiamGia;
import com.example.duantotnghiep.entity.SanPham;
import com.example.duantotnghiep.repository.GiamGiaRepository;
import com.example.duantotnghiep.repository.SanPhamRepository;
import com.example.duantotnghiep.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private GiamGiaRepository giamGiaRepository;

    @Override
    public SanPham applyDiscountAndAddToBill(UUID sanPhamId, UUID giamGiaId) {
        SanPham sanPham = sanPhamRepository.findById(sanPhamId).orElse(null);
        if (sanPham != null) {
            GiamGia giamGia = giamGiaRepository.findById(giamGiaId).orElse(null);
            if (giamGia != null) {
                BigDecimal giaBan = sanPham.getGiaBan();
                BigDecimal discountAmount = giamGia.getGiaGiam();
                BigDecimal giaSauKhuyenMai = giaBan.subtract(discountAmount);
                sanPham.setGiaBan(giaSauKhuyenMai);
                return sanPhamRepository.save(sanPham);
            }
        }
        return null;
    }
    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham add(SanPham SanPham) {
        return sanPhamRepository.save(SanPham);
    }

    @Override
    public SanPham update(UUID id, SanPham SanPham) {
        SanPham SanPham1=sanPhamRepository.findById(id).orElse(null);
        SanPham1.setId(SanPham.getId());
        SanPham1.setCongDung(SanPham.getCongDung());
        SanPham1.setGiamGia(SanPham.getGiamGia());
        SanPham1.setDoHot(SanPham.getDoHot());
        SanPham1.setGiaBan(SanPham.getGiaBan());
        SanPham1.setHinhDang(SanPham.getHinhDang());
        SanPham1.setTrangThai(SanPham.getTrangThai());
        SanPham1.setThanhPhan(SanPham.getThanhPhan());
        SanPham1.setXuatXu(SanPham.getXuatXu());
        SanPham1.setThuongHieu(SanPham.getThuongHieu());
        SanPham1.setMa(SanPham.getMa());
        SanPham1.setTen(SanPham.getTen());
        SanPham1.setGiaNhap(SanPham.getGiaNhap());
        SanPham1.setNgayNhap(SanPham.getNgayNhap());
        SanPham1.setMoTa(SanPham.getMoTa());
        return sanPhamRepository.save(SanPham1);
    }

    @Override
    public SanPham detail(UUID id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.sanPhamRepository.deleteById(id);
        return true;
    }
}
