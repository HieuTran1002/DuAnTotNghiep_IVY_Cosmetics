package com.example.datn.service.impl;

import com.example.datn.entity.ThanhPhan;
import com.example.datn.repository.ThanhPhanRepository;
import com.example.datn.service.ThanhPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThanhPhanServiceImpl implements ThanhPhanService {

    @Autowired
    private ThanhPhanRepository thanhPhanRepository;

    @Override
    public List<ThanhPhan> getAll() {
        return thanhPhanRepository.findAll();
    }
}
