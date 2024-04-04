package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "sanpham")
@Data
public class SanPhamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "idthanhphan",referencedColumnName = "id")
    private ThanhPhanEntity thanhPhanEntity;
    @ManyToOne
    @JoinColumn(name = "idcongdung",referencedColumnName = "id")
    private CongDungEntity congDungEntity;
    @ManyToOne
    @JoinColumn(name = "idthuonghieu",referencedColumnName = "id")
    private ThuongHieuEntity thuongHieuEntity;
    @ManyToOne
    @JoinColumn(name = "idhinhdang",referencedColumnName = "id")
    private HinhDangEntity hinhDangEntity;
    @ManyToOne
    @JoinColumn(name = "idxuatxu",referencedColumnName = "id")
    private XuatXuEntity xuatXuEntity;
    @ManyToOne
    @JoinColumn(name = "idgiamgia",referencedColumnName = "id")
    private GiamGiaEntity giamGiaEntity;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "gianhap")
    private BigDecimal giaNhap;
    @Column(name = "giaban")
    private BigDecimal giaBan;
    @Column(name = "trangthai")
    private Integer trangThai;
    @Column(name = "giasaukhuyenmai")
    private BigDecimal giaSauKhuyenMai;
    @Column(name = "ngaynhap")
    private Date ngayNhap;
    @Column(name = "dohot")
    private Integer doHot;
}
