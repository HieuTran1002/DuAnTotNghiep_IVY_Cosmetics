package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.HoaDon;
import com.example.duantotnghiep.entity.ViDiem;

public interface ViDiemService {

    ViDiem saveViDiem(ViDiem viDiem);

    void tichDiemKhiMuaHang(HoaDon hoaDon);
}
