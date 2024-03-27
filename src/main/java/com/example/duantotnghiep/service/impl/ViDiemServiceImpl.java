package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.HoaDon;
import com.example.duantotnghiep.entity.KhachHang;
import com.example.duantotnghiep.entity.ViDiem;
import com.example.duantotnghiep.repository.HoaDonRepository;
import com.example.duantotnghiep.repository.KhachHangRepository;
import com.example.duantotnghiep.repository.ViDiemRepository;
import com.example.duantotnghiep.service.ViDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ViDiemServiceImpl implements ViDiemService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private ViDiemRepository viDiemRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public ViDiem saveViDiem(ViDiem viDiem) {
        return viDiemRepository.save(viDiem);
    }

    @Override
    public void tichDiemKhiMuaHang(HoaDon hoaDon) {
        // Lấy thông tin khách hàng từ hóa đơn
        KhachHang khachHang = hoaDon.getKhachHang();

        // Lấy tổng số điểm tích lũy hiện tại của khách hàng
        ViDiem viDiem = new ViDiem();
        viDiem.setKhachHang(khachHang);
        // Thiết lập đối tượng KhachHang cho ViDiem


        // Tính toán số điểm tích lũy mới dựa trên tổng tiền của hóa đơn
        BigDecimal tongTienHoaDon = hoaDon.getTongTien();
        int soDiemMoi = tongTienHoaDon.intValue() / 10000; // Mỗi 10,000 VNĐ tương ứng với 1 điểm

        // Cập nhật số điểm tích lũy mới
        viDiem.setSoDiemDaCong(viDiem.getSoDiemDaCong().add(BigDecimal.valueOf(soDiemMoi)));

        // Lưu thông tin số điểm tích lũy mới vào cơ sở dữ liệu
        viDiemRepository.save(viDiem);
    }
}
