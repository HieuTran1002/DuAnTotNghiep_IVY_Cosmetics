package com.example.duantotnghiep.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "thanhphan")
@Data
public class ThanhPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "ma")
    private String maThanhPhan;
    @Column(name = "ten")
    private String tenThanhPhan;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "trangthai")
    private Integer trangThai;
}
