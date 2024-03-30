package com.example.duantotnghiep.service;

import com.example.duantotnghiep.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();
    MauSac add(MauSac mauSac);
    MauSac update(UUID id, MauSac mauSac);
    MauSac detail(UUID id);
    Boolean delete(UUID id);
}
