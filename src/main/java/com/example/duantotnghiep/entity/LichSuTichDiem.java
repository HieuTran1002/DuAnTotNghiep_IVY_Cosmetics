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
@Table(name = "lichsutichdiem")
public class LichSuTichDiem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idvidiem")
    private ViDiem viDiem;

    @ManyToOne
    @JoinColumn(name = "idhoadon")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "idquydoi")
    private QuyDoiDiem quyDoiDiem;

    @Column(name = "sodiemdadung")
    private Integer soDiemDaDung;

    @Column(name = "ngaysudung")
    private Date ngaySuDung;

    @Column(name = "sodiemcong")
    private Integer soDiemCong;

    @Column(name = "trangthai")
    private Integer trangThai;
}
