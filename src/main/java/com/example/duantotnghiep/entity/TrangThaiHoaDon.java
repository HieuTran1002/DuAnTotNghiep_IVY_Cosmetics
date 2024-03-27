package com.example.duantotnghiep.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "trangthaihoadon")
public class TrangThaiHoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idhoadon")
    private HoaDon hoaDon;

    @Column(name = "tenkhachhang", unique = true)
    private String tenKhachHang;

    @Column(name = "tenhoadon")
    private String tenHoaDon;

    @Column(name = "thoigianxuly")
    private BigDecimal thoiGianXuLy;

    @Column(name = "trangthai")
    private Integer trangThai;
}
