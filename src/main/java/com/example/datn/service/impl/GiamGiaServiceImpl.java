package com.example.datn.service.impl;

import com.example.datn.entity.GiamGia;
import com.example.datn.repository.GiamGiaRepository;
import com.example.datn.service.GiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiamGiaServiceImpl implements GiamGiaService {

    @Autowired
    private GiamGiaRepository giamGiaRepository;

    @Override
    public List<GiamGia> getAll() {
        return giamGiaRepository.findAll();
    }
}
