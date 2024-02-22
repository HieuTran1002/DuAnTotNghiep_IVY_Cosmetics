package com.example.duantotnghiep.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class XuatXu {

    private UUID id;

    private String maXuatXu;

    private String noiXuatXu;

    private String moTa;

    private Date ngayTao;

    private Date ngayCapNhat;

    private Integer trangThai;
}
