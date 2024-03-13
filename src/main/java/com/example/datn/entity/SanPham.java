package com.example.datn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Table(name = "sanpham")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "gianhap")
    private Double giaNhap;

    @Column(name = "giaban")
    private Double giaBan;

    @Column(name = "trangthai")
    private int trangThai;

    @Column(name = "giasaukhuyenmai")
    private Double giaSauKhuyenMai;

    @Column(name = "ngaynhap")
    private Date ngayNhap;

    @Column(name = "dohot")
    private int doHot;

    @ManyToOne
    @JoinColumn(name = "idthanhphan")
    private ThanhPhan thanhPhan;

    @ManyToOne
    @JoinColumn(name = "idcongdung")
    private CongDung congDung;

    @ManyToOne
    @JoinColumn(name = "idthuonghieu")
    private ThuongHieu thuongHieu;

    @ManyToOne
    @JoinColumn(name = "idhinhdang")
    private HinhDang hinhDang;

    @ManyToOne
    @JoinColumn(name = "idxuatxu")
    private XuatXu xuatXu;

    @ManyToOne
    @JoinColumn(name = "idgiamgia")
    private GiamGia giamGia;
}
