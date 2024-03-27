package com.example.duantotnghiep.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sanphamchitiet")
public class SanPhamChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idsanpham")
    private SanPham product;

    @ManyToOne
    @JoinColumn(name = "idmausac")
    private MauSac color;

    @ManyToOne
    @JoinColumn(name = "idanhsanpham")
    private AnhSanPham productImage;

    @Column(name = "soluongton")
    private Integer quantity;

    @Column(name = "trangthai")
    private Integer status;
}
