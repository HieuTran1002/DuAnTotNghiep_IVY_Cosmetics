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
@Table(name = "vidiem")
public class ViDiem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idkhachhang")
    private KhachHang khachHang;

    @Column(name = "tongdiem", unique = true)
    private String tongDiem;

    @Column(name = "sodiemdadung")
    private BigDecimal soDiemDaDung;

    @Column(name = "sodiemdacong")
    private BigDecimal soDiemDaCong;

    @Column(name = "trangthai")
    private Integer trangThai;
}
