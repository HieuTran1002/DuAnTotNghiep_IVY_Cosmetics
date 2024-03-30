package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.ThuongHieu;
import com.example.duantotnghiep.repository.ThuongHieuRepository;
import com.example.duantotnghiep.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;
    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuRepository.findAll();
    }

    @Override
    public ThuongHieu add(ThuongHieu ThuongHieu) {
        return thuongHieuRepository.save(ThuongHieu);
    }

    @Override
    public ThuongHieu update(UUID id, ThuongHieu ThuongHieu) {
        ThuongHieu ThuongHieu1=thuongHieuRepository.findById(id).orElse(null);
        ThuongHieu1.setId(ThuongHieu.getId());
        ThuongHieu1.setMa(ThuongHieu.getMa());
        ThuongHieu1.setTen(ThuongHieu.getTen());
        ThuongHieu1.setMoTa(ThuongHieu.getMoTa());
//        ThuongHieu1.setNgayTao(ThuongHieu.getNgayTao());
//        ThuongHieu1.setNgayCapNhat(ThuongHieu.getNgayCapNhat());
        ThuongHieu1.setTrangThai(ThuongHieu.getTrangThai());
        return thuongHieuRepository.save(ThuongHieu1);
    }

    @Override
    public ThuongHieu detail(UUID id) {
        return thuongHieuRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        this.thuongHieuRepository.deleteById(id);
        return true;
    }
}
