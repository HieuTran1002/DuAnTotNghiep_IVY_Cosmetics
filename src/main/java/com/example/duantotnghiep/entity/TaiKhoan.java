package com.example.duantotnghiep.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
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

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String matKhau;

    @Column(name = "email")
    private String email;

    @Column(name = "image")
    private String image;

    @Column(name = "trangthai")
    private Integer trangThai;

    @Column(name = "fullname")
    private String name;

    @Column(name = "sodienthoai")
    private String soDienThoai;

    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @Column(name = "gioitinh")
    private Boolean gioiTinh;

    @Column(name = "mataikhoan")
    private String maTaiKhoan;

    @Column(name = "ngaytao")
    private Date ngayTao;

    @Column(name = "ngaycapnhat")
    private Date ngayCapNhat;

    @OneToMany(mappedBy = "diachi", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<DiaChi> diaChiList;

    @OneToMany(mappedBy = "khachhang", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<KhachHang> KhachHangList;

    @OneToMany(mappedBy = "nhanvien", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<NhanVien> NhanVienList;

}
