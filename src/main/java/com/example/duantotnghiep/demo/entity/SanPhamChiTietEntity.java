package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "sanphamchitiet")
@Data
public class SanPhamChiTietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "idsanpham",referencedColumnName = "id")
    private SanPhamEntity sanPhamEntity;
    @ManyToOne
    @JoinColumn(name = "idmausac" ,referencedColumnName = "id")
    private MauSacEntity mauSacEntity;
    @ManyToOne
    @JoinColumn(name = "idanhsanpham",referencedColumnName = "id")
    private AnhSanPhamEntity anhSanPhamEntity;
    @Column(name = "soluongton")
    private Integer soLuongTon;
    @Column(name = "trangthai")
    private Integer trangThai;
}
