USE MASTER 
GO 
CREATE DATABASE ws_su24_bl2
GO
USE ws_su24_bl2
GO
CREATE TABLE danh_muc (
	id [int] IDENTITY(1,1) NOT NULL,
	ten_danh_muc nvarchar(100) NULL,
	CONSTRAINT danh_muc_PK PRIMARY KEY (id)
);
GO
CREATE TABLE san_pham (
	id [int] IDENTITY(1,1) NOT NULL,
	danh_muc_id  int NULL,
	ten_san_pham nvarchar(100) NULL,
	so_luong int NULL,
	gia_nhap decimal(38,0) NULL,
	gia_ban decimal(38,0) NULL,
	mieu_ta nvarchar(4000) NULL,
	CONSTRAINT san_pham_PK PRIMARY KEY (id),
	CONSTRAINT san_pham_FK FOREIGN KEY (danh_muc_id) REFERENCES danh_muc(id)
);
GO
CREATE TABLE hoa_don (
	id [int] IDENTITY(1,1) NOT NULL,
	ngay_tao datetime NULL,
	CONSTRAINT hoa_don_PK PRIMARY KEY (id),
);
GO
ALTER TABLE hoa_don ADD ten_nguoi_nhan nvarchar(100) NULL;
ALTER TABLE hoa_don ADD dia_chi nvarchar(100) NULL;
ALTER TABLE hoa_don ADD so_dien_thoai varchar(20) NULL;
ALTER TABLE hoa_don ADD trang_thai int DEFAULT 0 NULL;
GO
CREATE TABLE hoa_don_chi_tiet (
	id [int] IDENTITY(1,1) NOT NULL,
	hoa_don_id int NULL,
	san_pham_id int NULL,
	so_luong int NULL,
	don_gia decimal(38,0) DEFAULT 0 NULL,
	CONSTRAINT hoa_don_chi_tiet_PK PRIMARY KEY (id),
	CONSTRAINT hoa_don_chi_tiet_FK FOREIGN KEY (hoa_don_id) REFERENCES hoa_don(id),
	CONSTRAINT hoa_don_chi_tiet_FK_1 FOREIGN KEY (san_pham_id) REFERENCES san_pham(id)
);

GO 
-- Insert Danh Mục
SET IDENTITY_INSERT [dbo].[danh_muc] ON 
INSERT INTO danh_muc
(id, ten_danh_muc)
VALUES(1, N'danh mục 2');
INSERT INTO danh_muc
(id, ten_danh_muc)
VALUES(2, N'danh mục 4');
INSERT INTO danh_muc
(id, ten_danh_muc)
VALUES(3, N'danh mục 5');
INSERT INTO danh_muc
(id, ten_danh_muc)
VALUES(4, N'danh mục 1');
INSERT INTO danh_muc
(id, ten_danh_muc)
VALUES(5, N'danh mục 3');
SET IDENTITY_INSERT [dbo].[danh_muc] OFF 
SET IDENTITY_INSERT [dbo].[san_pham] ON 

-- Insert Sản Phẩm 
INSERT INTO san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(1,1, N'Sản phẩm 2', 200, 12000, 14000, N'Miêu tả 2');
INSERT INTO san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(2,1, N'Sản phẩm 1', 100, 10000, 15000, N'Miêu tả 1');
INSERT INTO san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(3,1, N'Sản phẩm 3', 150, 8000, 12000, N'Miêu tả 3');
INSERT INTO san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(4,2, N'Sản phẩm 6', 160, 12000, 18000, N'Miêu tả 6');
INSERT INTO san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(5,3, N'Sản phẩm 4', 120, 4000, 10000, N'Miêu tả 4');
INSERT INTO san_pham
(id, danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
VALUES(6,3, N'Sản phẩm 5', 130, 8000, 12000, N'Miêu tả 5');
SET IDENTITY_INSERT [dbo].[san_pham] OFF 
SET IDENTITY_INSERT [dbo].[hoa_don] ON 

-- Insert Hoá Đơn
INSERT INTO hoa_don
(id, ngay_tao, ten_nguoi_nhan, dia_chi, so_dien_thoai, trang_thai)
VALUES(1, '2022-10-01 03:52:55.597', N'Nguyễn Văn C', N'Thái Bình', N'0986789888', 0);
INSERT INTO hoa_don
(id, ngay_tao, ten_nguoi_nhan, dia_chi, so_dien_thoai, trang_thai)
VALUES(2, '2022-09-02 03:52:55.597', N'Nguyễn Văn B', N'Nam Định', N'0987654567', 1);
INSERT INTO hoa_don
(id, ngay_tao, ten_nguoi_nhan, dia_chi, so_dien_thoai, trang_thai)
VALUES(3, '2022-06-02 03:52:55.597', N'Nguyễn Văn A', N'Hà Nội', N'0123456789', 0);
SET IDENTITY_INSERT [dbo].[hoa_don] OFF 
SET IDENTITY_INSERT [dbo].[hoa_don_chi_tiet] ON 

-- Insert Hoá Đơn Chi tiết
INSERT INTO hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(1,1,1, 2, 14000);
INSERT INTO hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(2,1,1 ,1, 12000);
INSERT INTO hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(3,1,2, 1, 14000);
INSERT INTO hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(4,2,2, 1, 14000);
INSERT INTO hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(5,2,1, 1, 15000);
INSERT INTO hoa_don_chi_tiet
(id, hoa_don_id, san_pham_id, so_luong, don_gia)
VALUES(6,2,3, 2, 12000);
