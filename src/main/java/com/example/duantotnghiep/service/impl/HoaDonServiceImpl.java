package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.HoaDon;
import com.example.duantotnghiep.repository.HoaDonRepository;
import com.example.duantotnghiep.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;

public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public HoaDon saveHoaDon(HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

}
