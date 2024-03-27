package com.example.duantotnghiep.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quydoidiem")
public class QuyDoiDiem {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "sotiemtuongung")
    private String soTiemTuongUng;

    @Column(name = "sodiemtuongung")
    private String soDiemTuongUng;

    @Column(name = "trangthai")
    private Integer trangThai;

//    @OneToMany(mappedBy = "lichsutichdiem", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    List<SanPham> sanPhamList;

}
