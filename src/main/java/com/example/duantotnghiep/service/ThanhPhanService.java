package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.ThanhPhan;

import java.util.List;
import java.util.UUID;

public interface ThanhPhanService {
    List<ThanhPhan> getAll();
    ThanhPhan add(ThanhPhan ThanhPhan);
    ThanhPhan update(UUID id, ThanhPhan ThanhPhan);
    ThanhPhan detail(UUID id);
    Boolean delete(UUID id);
}
