package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "hoadon")
@Data
public class HoaDonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idnhanvien")
    private NhanVienEntity nhanVienEntity;

    @ManyToOne
    @JoinColumn(name = "idkhachhang")
    private KhachHangEntity khachHangEntity;

    @Column(name = "ma", unique = true)
    private String ma;

    @Column(name = "ngaytao")
    private Date ngayTao;

    @Column(name = "ngaythanhtoan")
    private Date ngayThanhToan;

    @Column(name = "tenkhachhang")
    private String tenKhachHang;

    @Column(name = "sodienthoai")
    private String soDienThoai;

    @Column(name = "tennguoinhan")
    private String tenNguoiNhan;

    @Column(name = "sdtnguoinhan")
    private String sdtNguoiNhan;

    @Column(name = "sotiengiam")
    private BigDecimal soTienGiam;

    @Column(name = "phiship")
    private BigDecimal phiShip;

    @Column(name = "sodiemsudung")
    private Integer soDiemSuDung;

    @Column(name = "sotienquydoi")
    private Integer soTienQuyDoi;

    @Column(name = "hinhthucmua")
    private Integer hinhThucMua;

    @Column(name = "hinhthucthanhtoan")
    private Integer hinhThucThanhToan;

    @Column(name = "hinhthucnhanhang")
    private Integer hinhThucNhanHang;

    @Column(name = "tongtien")
    private BigDecimal tongTien;

    @Column(name = "trangthai")
    private Integer trangThai;
}
