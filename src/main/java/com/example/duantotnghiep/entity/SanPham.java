package com.example.duantotnghiep.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sanpham")
public class SanPham {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdThanhPhan")
    @JsonBackReference
    private ThanhPhan thanhPhan;

    @ManyToOne
    @JoinColumn(name = "IdCongDung")
    @JsonBackReference
    private CongDung congDung;

    @ManyToOne
    @JoinColumn(name = "IdThuongHieu")
    @JsonBackReference
    private ThuongHieu thuongHieu;

    @ManyToOne
    @JoinColumn(name = "IdDanhMuc")
    @JsonBackReference
    private DanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name = "IdHinhDang")
    @JsonBackReference
    private HinhDang hinhDang;

    @ManyToOne
    @JoinColumn(name = "IdXuatXu")
    @JsonBackReference
    private XuatXu xuatXu;

    @ManyToOne
    @JoinColumn(name = "IdGiamGia")
    @JsonBackReference
    private GiamGia giamGia;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "gianhap")
    private BigDecimal GiaNhap;

    @Column(name = "giaban")
    private BigDecimal giaBan;

    @Column(name = "trangthai")
    private Integer trangThai;

    @Column(name = "GiaSauKhuyenMai")
    private BigDecimal ngayTao;

    @Column(name = "ngaynhap")
    private Date ngayNhap;

    @Column(name = "dohot")
    private int doHot;

}
