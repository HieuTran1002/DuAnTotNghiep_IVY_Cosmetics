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
}
