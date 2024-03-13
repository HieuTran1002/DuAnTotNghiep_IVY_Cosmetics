package com.example.datn.service.impl;

import com.example.datn.entity.CongDung;
import com.example.datn.repository.CongDungRepository;
import com.example.datn.service.CongDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongDungServiceImpl implements CongDungService {

    @Autowired
    private CongDungRepository congDungRepository;

    @Override
    public List<CongDung> getAll() {
        return congDungRepository.findAll();
    }
}
