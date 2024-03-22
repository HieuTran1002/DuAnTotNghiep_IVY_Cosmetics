package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "thuonghieu")
public class ThuongHieuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "ngaytao")
    private Date ngayTao;
    @Column(name = "ngaycapnhat")
    private Date ngayCapNhat;
    @Column(name = "trangthai")
    private Integer trangThai;
}
