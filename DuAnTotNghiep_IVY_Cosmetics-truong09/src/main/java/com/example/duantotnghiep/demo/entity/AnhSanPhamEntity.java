package com.example.duantotnghiep.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "anhsanpham")
@Data
public class AnhSanPhamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ma")
    private String maAnhSanPham;
    @Column(name = "ten")
    private String tenAnhSanPham;
    @Column(name = "trangthai")
    private Integer trangThai;
}
