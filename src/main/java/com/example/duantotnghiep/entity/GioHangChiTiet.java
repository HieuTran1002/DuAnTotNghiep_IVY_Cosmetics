package com.example.duantotnghiep.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "giohangchitiet")
public class GioHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idgiohang")
    private GioHang cart;

    @ManyToOne
    @JoinColumn(name = "idsanphamchitiet")
    private SanPham productDetail;

    @Column(name = "soluong")
    private Integer quantity;

    @Column(name = "dongia")
    private BigDecimal unitPrice;

    @Column(name = "dongiakhigiam")
    private BigDecimal discountedUnitPrice;

    @Column(name = "ghichu")
    private String note;

    @Column(name = "trangthai")
    private Integer status;
}
