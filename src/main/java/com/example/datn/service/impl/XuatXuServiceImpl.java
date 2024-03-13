package com.example.datn.service.impl;

import com.example.datn.entity.XuatXu;
import com.example.datn.repository.XuatXuRepository;
import com.example.datn.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XuatXuServiceImpl implements XuatXuService {

    @Autowired
    private XuatXuRepository xuatXuRepository;

    @Override
    public List<XuatXu> getAll() {
        return xuatXuRepository.findAll();
    }
}
