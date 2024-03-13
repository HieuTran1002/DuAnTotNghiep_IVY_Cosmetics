package com.example.datn.service.impl;

import com.example.datn.entity.HinhDang;
import com.example.datn.repository.HinhDangRepository;
import com.example.datn.service.HinhDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HinhDangServiceImpl implements HinhDangService {

    @Autowired
    private HinhDangRepository hinhDangRepository;

    @Override
    public List<HinhDang> getAll() {
        return hinhDangRepository.findAll();
    }
}
