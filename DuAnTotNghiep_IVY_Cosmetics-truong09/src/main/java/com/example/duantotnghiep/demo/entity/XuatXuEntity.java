package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "xuatxu")
@Data
public class XuatXuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "ngayxuatxu")
    private Date ngayXuatXu;
    @Column(name = "trangthai")
    private Integer trangThai;
}
