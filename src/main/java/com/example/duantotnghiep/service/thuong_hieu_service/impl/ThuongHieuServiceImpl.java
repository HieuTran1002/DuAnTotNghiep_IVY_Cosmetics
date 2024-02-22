package com.example.duantotnghiep.service.thuong_hieu_service.impl;

import com.example.duantotnghiep.entity.ThuongHieu;
import com.example.duantotnghiep.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl {

    @Autowired
    private ThuongHieuRepository thuongHieuRepository;

    public void generateFakeData() {
        List<ThuongHieu> fakeDataList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            ThuongHieu thuongHieu = new ThuongHieu();
            thuongHieu.setId(UUID.randomUUID());
            thuongHieu.setMaThuongHieu("TH" + i);
            thuongHieu.setTenThuongHieu("3CE" + i);
            thuongHieu.setMoTa("Description " + i);
            fakeDataList.add(thuongHieu);
        }

        thuongHieuRepository.saveAll(fakeDataList);
    }

    public List<ThuongHieu> getAll() {
        return thuongHieuRepository.findAll();
    }


}
