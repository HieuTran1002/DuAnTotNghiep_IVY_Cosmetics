package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "giohang")
@Data
public class GioHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "idkhachhang",referencedColumnName = "id")
    private KhachHangEntity khachHangEntity;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ngaytao")
    private Date ngayTao;
    @Column(name = "ngaycapnhat")
    private Date ngayCapNhat;
    @Column(name = "ghichu")
    private String ghiChu;
    @Column(name = "trangthai")
    private Integer trangThai;
    @OneToMany(mappedBy = "gioHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GioHangChiTietEntity> gioHangChiTietEntities;
}
