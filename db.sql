CREATE DATABASE su24_bl2;
GO
USE [su24_bl2]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ChucVu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[TenDem] [nvarchar](30) NULL,
	[Ho] [nvarchar](30) NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](100) NULL,
	[Sdt] [varchar](30) NULL,
	[MatKhau] [varchar](max) NULL,
	[IdCV] [int] NULL ,
	[TrangThai] [int] NULL,
    FOREIGN KEY (IdCV) REFERENCES ChucVu(ID),
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([Id], [Ma], [Ten]) VALUES (1, N'CV03', N'Phó giám Đốc')
INSERT [dbo].[ChucVu] ([Id], [Ma], [Ten]) VALUES (2, N'CV01', N'Trưởng Phòng Vip')
SET IDENTITY_INSERT [dbo].[ChucVu] OFF


SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([Id], [Ma], [Ten], [TenDem], [Ho], [GioiTinh], [NgaySinh], [DiaChi], [Sdt], [MatKhau], [IdCV], [TrangThai]) VALUES (1, N'NV01', N'Hung', N'Quang', N'Le', N'Nam', CAST(N'2003-08-10' AS Date), N'Bac Ninh', N'0962823303',  1, 1,  1)
INSERT [dbo].[NhanVien] ([Id], [Ma], [Ten], [TenDem], [Ho], [GioiTinh], [NgaySinh], [DiaChi], [Sdt], [MatKhau], [IdCV], [TrangThai]) VALUES (2, N'NV02', N'Khai', N'Văn', N'Tran', N'Nữ', CAST(N'2002-09-02' AS Date), N'Lai Chau 98', N'0962823303',1, 1, 1)
SET IDENTITY_INSERT [dbo].[NhanVien] OFF

SELECT * FROm NhanVien
SELECT * FROM ChucVu
