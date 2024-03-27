package com.example.duantotnghiep.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "giohang")
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idkhachhang")
    private KhachHang customer;

    @Column(name = "ma", unique = true)
    private String code;

    @Column(name = "ngaytao")
    private Date createdAt;

    @Column(name = "ngaycapnhat")
    private Date updatedAt;

    @Column(name = "ghichu")
    private String note;

    @Column(name = "trangthai")
    private Integer status;

}
