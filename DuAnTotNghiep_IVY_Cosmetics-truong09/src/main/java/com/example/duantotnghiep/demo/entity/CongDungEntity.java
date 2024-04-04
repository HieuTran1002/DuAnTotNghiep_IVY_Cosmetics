package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "congdung")
@Data
public class CongDungEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ma")
    private String maCongDung;
    @Column(name = "ten")
    private String tenConDung;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "trangthai")
    private Integer trangThai;
}
