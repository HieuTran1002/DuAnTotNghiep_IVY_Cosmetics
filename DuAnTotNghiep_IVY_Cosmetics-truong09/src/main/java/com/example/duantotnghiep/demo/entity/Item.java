package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Item {
    private String tenAnhSanPham;
    private String tenSanPham;
    private Integer soLuong;
    private BigDecimal giaBan;
}
