package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.sql.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "taikhoan")
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "idnhanvien",referencedColumnName = "id")
    private NhanVienEntity nhanVienEntity;
    @ManyToOne
    @JoinColumn(name = "iddiachi",referencedColumnName = "id")
    private DiaChiEntity diaChiEntity;
    @ManyToOne
    @JoinColumn(name = "idkhachhang",referencedColumnName = "id")
    private KhachHangEntity khachHangEntity;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String passWord;
    @Column(name = "ngaytao")
    private Date ngayTao;
    @Column(name = "ngaycapnhat")
    private Date ngayCapNhat;
    @Column(name = "trangthai")
    private Integer trangThai;

}
