package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "giamgia")
@Data
public class GiamGiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "hinhthucgiam")
    private Integer hinhThucGiam;
    @Column(name = "ngaybatdau")
    private Date ngayBatDau;
    @Column(name = "ngayketthuc")
    private Date ngayKetThuc;
    @Column(name = "dongia")
    private BigDecimal donGia;
    @Column(name = "giagiam")
    private BigDecimal giaGiam;
    @Column(name = "trangthai")
    private Integer trangThai;
}
