package com.example.duantotnghiep.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hoadon")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idnhanvien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "idkhachhang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "idvourcher")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "idvidiem")
    private ViDiem viDiem;

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