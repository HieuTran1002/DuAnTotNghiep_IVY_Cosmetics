package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "diachi")
public class DiaChiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "quocgia")
    private String quocGia;
    @Column(name = "thanhpho")
    private String thanhPho;
    @Column(name = "tinh")
    private String tinh;
    @Column(name = "quan")
    private String quan;
    @Column(name = "huyen")
    private String huyen;
    @Column(name = "ghichu")
    private String ghiChu;
    @Column(name = "trangthai")
    private Integer trangThai;
}
