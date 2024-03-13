CREATE DATABASE QLMyPham_IVY_Cosmetics
USE [QLMyPham_IVY_Cosmetics]

CREATE TABLE thanhphan (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(50) DEFAULT NULL,
    mota NVARCHAR(50) DEFAULT NULL,
    trangthai INT NULL
);

CREATE TABLE congdung (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(50) DEFAULT NULL,
    mota NVARCHAR(50) DEFAULT NULL,
    trangthai INT NULL
);

CREATE TABLE thuonghieu (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(50) DEFAULT NULL,
    mota NVARCHAR(50) DEFAULT NULL,
	ngaytao DATE NULL,
	ngaycapnhat DATE NULL,
    trangthai INT NULL
);

CREATE TABLE hinhdang (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(50) DEFAULT NULL,
    mota NVARCHAR(50) DEFAULT NULL,
    trangthai INT NULL
);

CREATE TABLE xuatxu (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(50) DEFAULT NULL,
	ngayxuatxu Date NULL,
    trangthai INT NULL
);

CREATE TABLE giamgia (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(20) NULL,
	hinhthucgiam INT NULL,
	ngaybatdau DATE NULL,
	ngayketthuc DATE NULL,
	dongia DECIMAL NULL,
	giagiam DECIMAL NULL,
    trangthai INT NULL
);

CREATE TABLE sanpham (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	idthanhphan UNIQUEIDENTIFIER,
	idcongdung UNIQUEIDENTIFIER,
    idthuonghieu UNIQUEIDENTIFIER,
    idhinhdang UNIQUEIDENTIFIER,
    idxuatxu UNIQUEIDENTIFIER,
    idgiamgia UNIQUEIDENTIFIER,
	ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(200) DEFAULT NULL,
    mota NVARCHAR(255) NULL,
    gianhap DECIMAL,
    giaban DECIMAL,
    trangthai INT NULL,
    giasaukhuyenmai DECIMAL,
    ngaynhap DATE,
    dohot INT NULL,
    FOREIGN KEY (idthanhphan) REFERENCES thanhphan(id),
    FOREIGN KEY (idcongdung) REFERENCES congdung(id),
	FOREIGN KEY (idthuonghieu) REFERENCES thuonghieu(id),
    FOREIGN KEY (idhinhdang) REFERENCES hinhdang(id),
    FOREIGN KEY (idxuatxu) REFERENCES xuatxu(id),
    FOREIGN KEY (idgiamgia) REFERENCES giamgia(id),
);

CREATE TABLE danhmuc (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    idsanpham UNIQUEIDENTIFIER,
	ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(50) DEFAULT NULL,
    trangthai INT NULL
	FOREIGN KEY (idsanpham) REFERENCES sanpham (id)
);

CREATE TABLE mausac (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(50) DEFAULT NULL,
    trangthai INT NULL
);

CREATE TABLE anhsanpham (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(50) DEFAULT NULL,
    trangthai INT NULL
);

CREATE TABLE sanphamchitiet (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    idsanpham UNIQUEIDENTIFIER,
    idmausac UNIQUEIDENTIFIER,
	idanhsanpham UNIQUEIDENTIFIER,
    soluongton INT DEFAULT NULL,
    trangthai INT NULL,
    FOREIGN KEY (idsanpham) REFERENCES sanpham(id),
    FOREIGN KEY (idmausac) REFERENCES mausac(id),
	FOREIGN KEY (idanhsanpham) REFERENCES anhsanpham(id)
);

CREATE TABLE khachhang (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma VARCHAR(20) UNIQUE,
	ten NVARCHAR(50) NULL,
    avatar VARCHAR(20) NULL,
	gioitinh BIT NULL,
	email NVARCHAR(255) NULL,
	sodienthoai NVARCHAR(20) NULL,
    ngaysinh DATE NULL,
	ngaytao DATE NULL,
    ngaycapnhat DATE NULL,
    trangthai INT NULL,
);

CREATE TABLE vourcher (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	nguoisohuu UNIQUEIDENTIFIER,
    ma VARCHAR(20) UNIQUE,
    ten NVARCHAR(20) NULL,
	ngaybatdau DATE NULL,
	ngayketthuc DATE NULL,
	ngaycapnhat DATE NULL,
	soluongma INT NULL,
	soluongdung INT NULL,
	giatritoithieudonhang DECIMAL NULL,
	giatrigiam DECIMAL NULL,
	hinhthucgiam INT NULL,
    mota NVARCHAR(50) DEFAULT NULL,
    trangthai INT NULL
	FOREIGN KEY (nguoisohuu) REFERENCES khachhang(id)
);

CREATE TABLE vidiem (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	idkhachhang UNIQUEIDENTIFIER,
    tongdiem VARCHAR(20) UNIQUE,
    sodiemdadung DECIMAL DEFAULT 0,
	sodiemdacong DECIMAL DEFAULT 0,
    trangthai INT NULL,
	FOREIGN KEY (idkhachhang) REFERENCES khachhang(id)
);

CREATE TABLE quydoidiem (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    sotientuongung DECIMAL DEFAULT 0,
	sodiemtuongung DECIMAL DEFAULT 0,
    trangthai INT NULL,
);

CREATE TABLE nhanvien (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma VARCHAR(20) UNIQUE,
	ten NVARCHAR(50) NULL,
    avatar VARCHAR(20) NULL,
	gioitinh BIT NULL,
	ngaysinh DATE NULL,
	email NVARCHAR(255) NULL,
	sodienthoai NVARCHAR(20) NULL,
	ngaytao DATE NULL,
    ngaycapnhat DATE NULL,
	chucvu NVARCHAR(50) NULL,
	trangthai INT NULL,
);

CREATE TABLE hoadon (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	idnhanvien UNIQUEIDENTIFIER,
    idkhachhang UNIQUEIDENTIFIER,
	idvourcher UNIQUEIDENTIFIER,
	idvidiem UNIQUEIDENTIFIER,
    ma VARCHAR(20) UNIQUE,
    ngaytao DATE NULL,
    ngaythanhtoan DATE NULL,
	tenkhachhang NVARCHAR(50) NULL,
    sodienthoai VARCHAR(20) NULL,
    tennguoinhan NVARCHAR(255) NULL,
    sdtnguoinhan NVARCHAR(255) NULL,
    sotiengiam MONEY,
    phiship MONEY,
	sodiemsudung INT,
    sotienquydoi INT,
    hinhthucmua INT, -- 1 online: buy as accounts, 0 offline
    hinhthucthanhtoan INT, -- 1 VNPAY, 0 Tiền mặt, 3 Khi nhận hàng
    hinhthucnhanhang INT, -- 1 giao hàng, 0 tại quầy
    tongtien DECIMAL,
    trangthai INT NULL,
    FOREIGN KEY (idnhanvien) REFERENCES nhanvien(id),
    FOREIGN KEY (idkhachhang) REFERENCES khachhang(id),
	FOREIGN KEY (idvourcher) REFERENCES vourcher(id),
	FOREIGN KEY (idvidiem) REFERENCES vidiem(id)
);

CREATE TABLE hoadonchitiet (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    idhoadon UNIQUEIDENTIFIER,
    idsanpham UNIQUEIDENTIFIER,
    soluong INT,
    dongia DECIMAL,
    trangthai INT NULL,
    FOREIGN KEY (idhoadon) REFERENCES hoadon(id),
    FOREIGN KEY (idsanpham) REFERENCES sanpham(id)
);

CREATE TABLE lichsutichdiem (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	idvidiem UNIQUEIDENTIFIER NULL,
    idhoadon UNIQUEIDENTIFIER NULL,
    idquydoi UNIQUEIDENTIFIER NULL,
    sodiemdadung INT NULL,
    ngaysudung DATE NULL,
    sodiemcong INT NULL,
    trangthai INT NULL,
    FOREIGN KEY (idvidiem) REFERENCES vidiem(id),
    FOREIGN KEY (idhoadon) REFERENCES hoadon(id),
    FOREIGN KEY (idquydoi) REFERENCES quydoidiem(id)
);

CREATE TABLE trangthaihoadon (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	idhoadon UNIQUEIDENTIFIER NULL,
    tenkhachhang VARCHAR(20) UNIQUE,
    tenhoadon NVARCHAR(50) DEFAULT NULL,
	thoigianxuly DECIMAL DEFAULT NULL,
    trangthai INT NULL,
	FOREIGN KEY (idhoadon) references hoadon(id)
);

CREATE TABLE giohang (
	id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	idkhachhang UNIQUEIDENTIFIER NULL,
	ma VARCHAR(20) UNIQUE,
	ngaytao DATE NULL,
	ngaycapnhat DATE NULL,
	ghichu NVARCHAR(255) NULL,
	trangthai INT NULL,
	FOREIGN KEY (idkhachhang) references khachhang(id)
)

CREATE TABLE giohangchitiet (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    idgiohang UNIQUEIDENTIFIER NULL,
    idsanphamchitiet UNIQUEIDENTIFIER NULL,
    soluong INT NULL,
	dongia DECIMAL NULL,
	dongiakhigiam DECIMAL NULL,
    ghichu NVARCHAR(255) NULL,
    trangthai INT NULL,
    FOREIGN KEY (idgiohang) REFERENCES giohang(id),
    FOREIGN KEY (idsanphamchitiet) REFERENCES sanphamchitiet(id)
);

CREATE TABLE diachi (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    ma NVARCHAR(50) DEFAULT NULL,
    quocgia NVARCHAR(50) DEFAULT NULL,
    thanhpho NVARCHAR(50) DEFAULT NULL,
    tinh NVARCHAR(250) DEFAULT NULL,
    quan NVARCHAR(250) DEFAULT NULL,
    huyen NVARCHAR(50) DEFAULT NULL,
	ghichu NVARCHAR(255) DEFAULT NULL,
    trangthai INT NULL,
);	

CREATE TABLE taikhoan (
	id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	idnhanvien UNIQUEIDENTIFIER,
	iddiachi UNIQUEIDENTIFIER,
    idkhachhang UNIQUEIDENTIFIER,
	ma VARCHAR(50) NULL,
	ten NVARCHAR(255) NULL,
	username NVARCHAR(255),
	password NVARCHAR(255),
	ngaytao DATE NULL,
    ngaycapnhat DATE NULL,
    trangthai INT NULL,
	FOREIGN KEY (idnhanvien) REFERENCES nhanvien(id),
    FOREIGN KEY (iddiachi) REFERENCES diachi(id),
	FOREIGN KEY (idkhachhang) REFERENCES khachhang(id)
);





-- INSERT VALUE --

INSERT INTO ThanhPhan (Ma, Ten, MoTa, TrangThai) VALUES 
		('TP001', 'Dầu', 'Thành phần dầu dưỡng', 1),
		('TP002', 'Wax', 'Thành phần tạo độ bám', 1),
		('TP003', 'Màu', 'Thành phần tạo màu', 1);

INSERT INTO CongDung (Ma, Ten, TrangThai) VALUES 
		('CD001', 'Dưỡng môi', 1),
		('CD002', 'Tạo màu', 1),
		('CD003', 'Làm đẹp', 1);
		select * from CongDung p where p.ma = ?1
		delete from CongDung where ma = 'CD001'
		update CongDung set ma = 'vv', ten = 'conca', TrangThai = 0 where ma = 'CD002'
INSERT INTO ThuongHieu (Ma, Ten, MoTa, TrangThai) VALUES 
		('TH001', 'MAC', 'Thương hiệu mỹ phẩm chất lượng', 1),
		('TH002', 'Maybelline', 'Thương hiệu mỹ phẩm phổ biến', 1),
		('TH003', 'L''Oreal', 'Thương hiệu mỹ phẩm cao cấp', 1);

INSERT INTO DanhMuc (Ma, Ten, TrangThai) VALUES 
		('DM001', 'Son dưỡng', 1),
		('DM002', 'Son lì', 1),
		('DM003', 'Son kem', 1);


INSERT INTO HinhDang (Ma, Ten, TrangThai) VALUES 
		('HD001', 'Chuôi', 1),
		('HD002', 'Lì', 1),
		('HD003', 'Kem', 1);

INSERT INTO XuatXu (Ma, Ten, TrangThai) VALUES 
		('XX001', 'Hàn Quốc', 1),
		('XX002', 'Mỹ', 1),
		('XX003', 'Pháp', 1);

INSERT INTO GiamGia (Ma, Ten, HinhThucGiam, NgayBatDau, NgayKetThuc, DonGia, GiaGiam, TrangThai) VALUES 
		('GG001', 'Giảm giá 10%', 1, '2024-03-01', '2024-03-31', 50, 10, 1),
		('GG002', 'Giảm giá 20%', 1, '2024-04-01', '2024-04-30', 100, 20, 1),
		('GG003', 'Giảm giá 30%', 1, '2024-05-01', '2024-05-31', 150, 30, 1);
		select * from GiamGia where ma = 'GG001'
INSERT INTO MauSac (Ma, Ten, TrangThai) VALUES 
		('MS001', 'Đỏ', 1),
		('MS002', 'Hồng', 1),
		('MS003', 'Cam', 1);

INSERT INTO AnhSanPham (Ma, Ten, TrangThai) VALUES 
		('ASP001', 'Son MAC đỏ', 1),
		('ASP002', 'Son Maybelline hồng', 1),
		('ASP003', 'Son L''Oreal cam', 1);

INSERT INTO SanPham (IdThanhPhan, IdCongDung, IdThuongHieu, IdHinhDang, IdXuatXu, IdGiamGia, Ma, Ten, MoTa, GiaNhap, GiaBan, TrangThai, GiaSauKhuyenMai, NgayNhap, DoHot) VALUES 
		('TP001', 'CD001', 'TH001', 'HD001', 'XX001', 'GG001', 'SP001', 'Son dưỡng MAC đỏ', 'Son dưỡng môi chất lượng từ MAC', 50000, 70000, 1, 60000, '2024-03-01', 1),
		('TP002', 'CD002', 'TH002', 'HD002', 'XX002', 'GG002', 'SP002', 'Son lì Maybelline hồng', 'Son lì tạo màu tự nhiên từ Maybelline', 60000, 80000, 1, 64000, '2024-04-01', 1),
		('TP003', 'CD003', 'TH003', 'HD003', 'XX003', 'GG003', 'SP003', 'Son kem L''Oreal cam', 'Son kem tạo màu sắc sảo từ L''Oreal', 70000, 90000, 1, 77000, '2024-05-01', 1);
	select * from SanPham
	select * from ThanhPhan
	select * from CongDung
	select * from ThuongHieu
	select * from HinhDang
	select * from XuatXu
	select * from GiamGia

	select * from DanhMuc

	/*hien thi ten danh muc*/
	select sp.Ma, sp.Ten, dm.Ten
	from dbo.DanhMuc as dm
	inner join dbo.SanPham as sp on sp.Ma = dm.Ma


INSERT INTO SanPhamChiTiet (IdSanPham, IdMauSac, IdAnhSanPham, SoLuongTon, TrangThai) VALUES 
		('SP001', 'MS001', 'ASP001', 50, 1),
		('SP002', 'MS002', 'ASP002', 70, 1),
		('SP003', 'MS003', 'ASP003', 80, 1);

INSERT INTO KhachHang (Ma, Ten, Avatar, GioiTinh, Email, SoDienThoai, NgaySinh, NgayTao, NgayCapNhat, TrangThai) VALUES 
		('KH001', 'Nguyễn Văn A', 'avatar1.gif', 1, 'nguyenvana@example.com', '0123456789', '1990-01-01', '2024-03-01', '2024-03-01', 1),
		('KH002', 'Trần Thị B', 'avatar2.gif', 0, 'tranthib@example.com', '0987654321', '1995-05-05', '2024-03-02', '2024-03-02', 1),
		('KH003', 'Lê Văn C', 'avatar3.gif', 1, 'levanc@example.com', '0365987412', '1988-12-20', '2024-03-03', '2024-03-03', 1);

INSERT INTO ViDiem (IdKhachHang, TongDiem, SoDiemDaDung, SoDiemDaCong, TrangThai) VALUES 
		('KH001', 'VD001', 100, 50, 1),
		('KH002', 'VD002', 200, 100, 1),
		('KH003', 'VD003', 150, 80, 1);

INSERT INTO QuyDoiDiem (SoTienTuongUng, SoDiemTuongUng, TrangThai) VALUES 
		(100000, 50, 1),
		(200000, 100, 1),
		(150000, 75, 1);

INSERT INTO DiaChi (Ma, QuocGia, ThanhPho, Tinh, Quan, Huyen, GhiChu, TrangThai) VALUES 
		('DC001', 'Việt Nam', 'Hà Nội', 'Hà Nội', 'Ba Đình', NULL, 'Địa chỉ giao hàng', 1),
		('DC002', 'Việt Nam', 'Hồ Chí Minh', 'Hồ Chí Minh', 'Quận 1', NULL, 'Địa chỉ nhận hàng', 1),
		('DC003', 'Việt Nam', 'Đà Nẵng', 'Đà Nẵng', 'Quận Sơn Trà', NULL, 'Địa chỉ giao nhận', 1);

INSERT INTO NhanVien (Ma, Ten, Avatar, GioiTinh, NgaySinh, Email, SoDienThoai, NgayTao, NgayCapNhat, ChucVu, TrangThai) VALUES 
		('NV001', 'Nguyễn Văn D', NULL, 1, '1990-02-02', 'nguyenvand@example.com', '0987654321', '2024-03-01', '2024-03-01', 'Nhân viên bán hàng', 1),
		('NV002', 'Trần Thị E', NULL, 0, '1995-06-06', 'tranthe@example.com', '0123456789', '2024-04-01', '2024-04-01', 'Nhân viên giao hàng', 1),
		('NV003', 'Lê Văn F', NULL, 1, '1988-11-11', 'levanf@example.com', '0369852147', '2024-05-01', '2024-05-01', 'Quản lý cửa hàng', 1);

INSERT INTO GioHang (IdKhachHang, Ma, NgayTao, NgayCapNhat, GhiChu, TrangThai) VALUES 
		('KH001', 'GH001', '2024-03-01', '2024-03-01', 'Ghi chú đơn hàng', 1),
		('KH002', 'GH002', '2024-04-01', '2024-04-01', 'Ghi chú đơn hàng', 1),
		('KH003', 'GH003', '2024-05-01', '2024-05-01', 'Ghi chú đơn hàng', 1);

INSERT INTO Vourcher (NguoiSoHuu, Ma, Ten, NgayBatDau, NgayKetThuc, NgayCapNhat, SoLuongMa, SoLuongDung, GiaTriToiThieuDonHang, GiaTriGiam, HinhThucGiam, MoTa, TrangThai) VALUES 
		((SELECT Id FROM KhachHang WHERE Ma = 'KH001'), 'VOU001', 'Voucher Giảm Giá 10%', '2024-03-01', '2024-03-31', '2024-03-01', 100, 0, 200000, 10000, 1, 'Voucher giảm giá cho đơn hàng từ 200,000 VND trở lên', 1),
		((SELECT Id FROM KhachHang WHERE Ma = 'KH002'), 'VOU002', 'Voucher Giảm Giá 20%', '2024-04-01', '2024-04-30', '2024-04-01', 100, 0, 300000, 20000, 1, 'Voucher giảm giá cho đơn hàng từ 300,000 VND trở lên', 1),
		((SELECT Id FROM KhachHang WHERE Ma = 'KH003'), 'VOU003', 'Voucher Giảm Giá 30%', '2024-05-01', '2024-05-31', '2024-05-01', 100, 0, 400000, 30000, 1, 'Voucher giảm giá cho đơn hàng từ 400,000 VND trở lên', 1);

INSERT INTO LichSuTichDiem (IdViDiem, IdHoaDon, IdQuyDoi, SoDiemDaDung, NgaySuDung, SoDiemCong, TrangThai) VALUES 
		(NULL, NULL, NULL, 50, '2024-03-01', NULL, 1),
		(NULL, NULL, NULL, 60, '2024-04-01', NULL, 1),
		(NULL, NULL, NULL, 70, '2024-05-01', NULL, 1);

INSERT INTO TrangThaiHoaDon (TenKhachHang, TenHoaDon, ThoiGianXuLy, TrangThai) VALUES 
		('Nguyễn Văn A', 'Đơn hàng 001', 2, 1),
		('Trần Thị B', 'Đơn hàng 002', 3, 1),
		('Lê Văn C', 'Đơn hàng 003', 1, 1);

/* TEST

INSERT INTO LichSuTichDiem (IdViDiem, IdHoaDon, IdQuyDoi, SoDiemDaDung, NgaySuDung, SoDiemCong, TrangThai) VALUES 
		((SELECT Id FROM ViDiem WHERE Ma = 'VD001'), (SELECT Id FROM HoaDon WHERE Ma = 'HD001'), (SELECT Id FROM QuyDoiDiem WHERE ...), 50, '2024-03-01', 20, 1),
		((SELECT Id FROM ViDiem WHERE Ma = 'VD002'), (SELECT Id FROM HoaDon WHERE Ma = 'HD002'), (SELECT Id FROM QuyDoiDiem WHERE ...), 60, '2024-04-01', 25, 1),
		((SELECT Id FROM ViDiem WHERE Ma = 'VD003'), (SELECT Id FROM HoaDon WHERE Ma = 'HD003'), (SELECT Id FROM QuyDoiDiem WHERE ...), 70, '2024-05-01', 30, 1);

INSERT INTO GioHangChiTiet (IdGioHang, IdSanPhamChiTiet, SoLuong, DonGia, DonGiaKhiGiam, GhiChu, TrangThai) VALUES 
		((SELECT Id FROM GioHang WHERE Ma = 'GH001'), (SELECT Id FROM SanPhamChiTiet WHERE Id = ...), 2, 150000, 120000, 'Sản phẩm yêu thích', 1),
		((SELECT Id FROM GioHang WHERE Ma = 'GH001'), (SELECT Id FROM SanPhamChiTiet WHERE Id = ...), 1, 250000, 200000, 'Sản phẩm khuyến mãi', 1),
		((SELECT Id FROM GioHang WHERE Ma = 'GH002'), (SELECT Id FROM SanPhamChiTiet WHERE Id = 'SP003'), 3, 180000, 150000, 'Sản phẩm mới', 1

INSERT INTO Vourcher (NguoiSoHuu, Ma, Ten, NgayBatDau, NgayKetThuc, NgayCapNhat, SoLuongMa, SoLuongDung, GiaTriToiThieuDonHang, GiaTriGiam, HinhThucGiam, MoTa, TrangThai) VALUES 
		((SELECT Id FROM KhachHang WHERE Ma = 'KH001'), 'VOU001', 'Voucher Giảm Giá 10%', '2024-03-01', '2024-03-31', '2024-03-01', 100, 0, 200000, 10000, 1, 'Voucher giảm giá cho đơn hàng từ 200,000 VND trở lên', 1),
		((SELECT Id FROM KhachHang WHERE Ma = 'KH002'), 'VOU002', 'Voucher Giảm Giá 20%', '2024-04-01', '2024-04-30', '2024-04-01', 100, 0, 300000, 20000, 1, 'Voucher giảm giá cho đơn hàng từ 300,000 VND trở lên', 1),
		((SELECT Id FROM KhachHang WHERE Ma = 'KH003'), 'VOU003', 'Voucher Giảm Giá 30%', '2024-05-01', '2024-05-31', '2024-05-01', 100, 0, 400000, 30000, 1, 'Voucher giảm giá cho đơn hàng từ 400,000 VND trở lên', 1);

*/

-- TEST --

SELECT * FROM ThanhPhan;

SELECT * FROM CongDung;

SELECT * FROM ThuongHieu;

SELECT * FROM DanhMuc;

SELECT * FROM HinhDang;

SELECT * FROM XuatXu;

SELECT * FROM GiamGia;

SELECT * FROM MauSac;

SELECT * FROM AnhSanPham;

SELECT * FROM SanPham;

SELECT * FROM SanPhamChiTiet;

SELECT * FROM KhachHang;

SELECT * FROM Vourcher;

SELECT * FROM ViDiem;

SELECT * FROM QuyDoiDiem;

SELECT * FROM NhanVien;

SELECT * FROM HoaDon;

SELECT * FROM HoaDonChiTiet;

SELECT * FROM LichSuTichDiem;

SELECT * FROM TrangThaiHoaDon;

SELECT * FROM GioHang;

SELECT * FROM GioHangChiTiet;

SELECT * FROM DiaChi;

SELECT * FROM TaiKhoan;
