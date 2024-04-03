package com.example.duantotnghiep.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "taikhoan")
public class TaiKhoan {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String matKhau;

    @Column(name = "ngaytao")
    private Date ngayTao;

    @Column(name = "ngaycapnhat")
    private Date ngayCapNhat;

    @Column(name = "trangthai")
    private Integer trangThai;

    @Column(name = "roles")
    private Integer roles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idnhanvien")
    private NhanVien nhanVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddiachi")
    private DiaChi diaChi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idkhachhang")
    private KhachHang khachHang;
}