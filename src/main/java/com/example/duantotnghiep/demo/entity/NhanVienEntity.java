package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "nhanvien")
public class NhanVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "gioitinh")
    private Boolean gioiTinh;
    @Column(name = "ngaysinh")
    private Date ngaySinh;
    @Column(name = "email")
    private String email;
    @Column(name = "sodienthoai")
    private String soDienThoai;
    @Column(name = "ngaytao")
    private Date ngayTao;
    @Column(name = "ngaycapnhat")
    private Date ngayCapNhat;
    @Column(name = "chucvu")
    private String chucVu;
    @Column(name = "trangthai")
    private Integer trangThai;
}
