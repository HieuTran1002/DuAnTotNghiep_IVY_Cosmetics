package com.example.duantotnghiep.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThuongHieu {

    private UUID id;

    private String maThuongHieu;

    private String tenThuongHieu;

    private String moTa;

    private Date ngayTao;

    private Date ngayCapNhat;

}
