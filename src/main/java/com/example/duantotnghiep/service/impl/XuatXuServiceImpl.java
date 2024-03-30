package com.example.duantotnghiep.service.impl;

import com.example.duantotnghiep.entity.XuatXu;
import com.example.duantotnghiep.repository.XuatXuRepository;
import com.example.duantotnghiep.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class XuatXuServiceImpl implements XuatXuService {
    @Autowired
    private XuatXuRepository xuatXuRepository;

    @Override
    public List<XuatXu> getAll() {
        return xuatXuRepository.findAll();
    }

    @Override
    public XuatXu add(XuatXu xuatXu) {
        return xuatXuRepository.save(xuatXu);
    }

    @Override
    public XuatXu update(UUID id, XuatXu xuatXu) {
        XuatXu xuatXu1=xuatXuRepository.findById(id).orElse(null);
        xuatXu1.setId(xuatXu.getId());
        xuatXu1.setMa(xuatXu.getMa());
        xuatXu1.setTen(xuatXu.getTen());
//        xuatXu1.setNgayXuatXu(xuatXu.getNgayXuatXu());
        xuatXu1.setTrangThai(xuatXu.getTrangThai());
        return xuatXuRepository.save(xuatXu1);
    }

    @Override
    public XuatXu detail(UUID id) {
        return xuatXuRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        xuatXuRepository.deleteById(id);
        return true;
    }
}
