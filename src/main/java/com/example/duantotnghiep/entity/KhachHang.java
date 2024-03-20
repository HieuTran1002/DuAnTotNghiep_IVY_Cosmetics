package com.example.duantotnghiep.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "khachhang")
public class KhachHang {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "anh")
    private String image;

    @Column(name = "gioitinh")
    private Boolean gioiTinh;

    @Column(name = "sodienthoai")
    private String soDienThoai;

    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @Column(name = "ngaytao")
    private Date ngayTao;

    @Column(name = "ngaycapnhat")
    private Date ngayCapNhat;

    @Column(name = "trangthai")
    private Integer trangThai;

    @OneToMany(mappedBy = "khachhang", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Voucher> voucherLists;

    public KhachHang(UUID id, String ma, String ten, String image, Boolean gioiTinh, String soDienThoai, Date ngaySinh, Date ngayTao, Date ngayCapNhat, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.image = image;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
        this.trangThai = trangThai;
    }
}
