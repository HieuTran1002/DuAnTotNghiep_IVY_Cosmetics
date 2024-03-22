package com.example.duantotnghiep.demo.service.impl;

import com.example.duantotnghiep.demo.entity.XuatXuEntity;
import com.example.duantotnghiep.demo.repository.XuatXuRepository;
import com.example.duantotnghiep.demo.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class XuatXuServiceImpl implements XuatXuService {
    @Autowired
    private XuatXuRepository xuatXuRepository;

    @Override
    public List<XuatXuEntity> getAll() {
        return xuatXuRepository.findAll();
    }

    @Override
    public XuatXuEntity add(XuatXuEntity xuatXuEntity) {
        return xuatXuRepository.save(xuatXuEntity);
    }

    @Override
    public XuatXuEntity update(UUID id, XuatXuEntity xuatXuEntity) {
        XuatXuEntity xuatXuEntity1=xuatXuRepository.findById(id).orElse(null);
        xuatXuEntity1.setId(xuatXuEntity.getId());
        xuatXuEntity1.setMa(xuatXuEntity.getMa());
        xuatXuEntity1.setTen(xuatXuEntity.getTen());
        xuatXuEntity1.setNgayXuatXu(xuatXuEntity.getNgayXuatXu());
        xuatXuEntity1.setTrangThai(xuatXuEntity.getTrangThai());
        return xuatXuRepository.save(xuatXuEntity1);
    }

    @Override
    public XuatXuEntity detail(UUID id) {
        return xuatXuRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(UUID id) {
        xuatXuRepository.deleteById(id);
        return true;
    }
}
