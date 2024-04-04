package com.example.duantotnghiep.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "mausac")
public class MauSacEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ma")
    private String maMauSac;
    @Column(name = "ten")
    private String tenMauSac;
    @Column(name = "trangthai")
    private Integer trangThai;

}
