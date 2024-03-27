package com.example.duantotnghiep.repository;

import com.example.duantotnghiep.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {

//    @Query("SELECT new com.example.duantotnghiep.response.KhachHangResponse(tk.id, tk.maTaiKhoan, tk.name, tk.email, tk.soDienThoai, dc.diaChi) " +
//            "FROM TaiKhoan tk JOIN tk.diaChiList dc WHERE tk.loaiTaiKhoan.name = 'USER' AND dc.trangThai = 1 AND tk.trangThai = 1 ORDER BY tk.ngayTao DESC")
//    Page<KhachHangResponse> findlistKhachHang(Pageable pageable);
//
//    @Query("SELECT new com.example.duantotnghiep.response.KhachHangResponse(tk.id, tk.maTaiKhoan, tk.name, tk.email, tk.soDienThoai, dc.diaChi) " +
//            "FROM TaiKhoan tk JOIN tk.diaChiList dc WHERE tk.loaiTaiKhoan.name = 'USER' AND (tk.name like %:key% OR tk.soDienThoai like %:key% OR tk.email like %:key%) AND dc.trangThai = 1 AND tk.trangThai = 1")
//    List<KhachHangResponse> findByKeyToKhachHang(@Param("key") String key);
//
//    @Query("SELECT new com.example.duantotnghiep.response.KhachHangResponse(tk.id, tk.maTaiKhoan, tk.name, tk.email, tk.soDienThoai, dc.diaChi) " +
//            "FROM TaiKhoan tk JOIN tk.diaChiList dc JOIN tk.hoaDonKhachHangList hd WHERE hd.id = :id")
//    KhachHangResponse findByKhachHangByIdHoaDon(@Param("id") UUID id);
//
//    @Query("SELECT new com.example.duantotnghiep.response.KhachHangResponse(tk.id, tk.maTaiKhoan, tk.name, tk.email, tk.soDienThoai, dc.diaChi) " +
//            "FROM TaiKhoan tk JOIN tk.diaChiList dc WHERE tk.id = :id AND dc.trangThai = 1")
//    KhachHangResponse detailKhachHang(@Param("id") UUID id);
//
//    @Query("SELECT new com.example.duantotnghiep.response.QLKhachHangResponse(tk.id, tk.name, tk.email, tk.soDienThoai, tk.image, tk.gioiTinh, tk.maTaiKhoan, tk.username, tk.matKhau, tk.ngaySinh, tk.trangThai, dc.diaChi) " +
//            "FROM TaiKhoan tk JOIN tk.diaChiList dc WHERE dc.trangThai = 1 AND tk.loaiTaiKhoan.name = ('USER') AND (:trangThai is null or tk.trangThai = :trangThai) AND (:name is null or tk.name like %:name%) AND (:soDienThoai is null or tk.soDienThoai like %:soDienThoai%) AND (:maTaiKhoan is null or tk.maTaiKhoan like %:maTaiKhoan%)")
//    Page<QLKhachHangResponse> findlistQLKhachHang(@Param("trangThai") Integer trangThai, @Param("name") String name, @Param("soDienThoai") String soDienThoai, @Param("maTaiKhoan") String maTaiKhoan, Pageable pageable);
//
//    @Query("SELECT new com.example.duantotnghiep.response.QLKhachHangResponse(tk.id, tk.name, tk.email, tk.soDienThoai, tk.image, tk.gioiTinh, tk.maTaiKhoan, tk.username, tk.matKhau, tk.ngaySinh, tk.trangThai, dc.diaChi) " +
//            "FROM TaiKhoan tk JOIN tk.diaChiList dc WHERE tk.id = :id AND dc.trangThai = 1")
//    QLKhachHangResponse detailQLKhachHang(@Param("id") UUID id);
//
//    @Query("SELECT new com.example.duantotnghiep.response.QLKhachHangResponse(tk.id, tk.name, tk.email, tk.soDienThoai, tk.image, tk.gioiTinh, tk.maTaiKhoan, tk.username, tk.matKhau, tk.ngaySinh, tk.trangThai, dc.diaChi) " +
//            "FROM TaiKhoan tk JOIN tk.diaChiList dc WHERE tk.maTaiKhoan = :key OR tk.soDienThoai = :key OR tk.name = :key OR tk.email = :key ")
//    List<QLKhachHangResponse> findByKeyQLToKhachHang(@Param("key") String key);
//
//    @Query("SELECT tk FROM TaiKhoan tk WHERE tk.loaiTaiKhoan.name = ('USER') ")
//    List<TaiKhoan> listKhachHang();
//
//    List<TaiKhoan> findBySoDienThoai(String soDienThoai);
//
//    List<TaiKhoan> findByEmail(String email);

}
