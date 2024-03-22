package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "giohangchitiet")
@Data
public class GioHangChiTietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "idgiohang",referencedColumnName = "id")
    private GioHangEntity gioHang;
    @ManyToOne
    @JoinColumn(name = "idsanphamchitiet",referencedColumnName = "id")
    private SanPhamChiTietEntity sanPhamChiTietEntity;
    @Column(name = "soluong")
    private UUID soLuong;
    @Column(name = "dongia")
    private BigDecimal donGia;
    @Column(name = "dongiakhigiam")
    private BigDecimal donGiaKhiGiam;
    @Column(name = "ghichu")
    private String ghiChu;
    @Column(name = "trangthai")
    private Integer trangThai;
}
