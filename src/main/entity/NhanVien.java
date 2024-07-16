/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.entity;

import java.util.Date;

/**
 *
 * @author hangnt
 */
public class NhanVien {

    private Integer id;

    private String ma;

    private String ten;

    private String ho;

    private String tenDem;

    private String gioiTinh;

    private Date ngaySinh;

    private String diaChi;

    private String sdt;

    private Integer trangThai;

    // C1: Mapping binh thuong tat ca cac truong giong CSDL 
    // C2: Mapping bang 1 doi tuong 
//    private Integer idCV;
    private ChucVu chucVu;

    private String matKhau;

    public NhanVien() {
    }

    public NhanVien(Integer id, String ma, String ten, String ho, String tenDem,
            String gioiTinh, Date ngaySinh, String diaChi, String sdt,
            Integer trangThai, ChucVu chucVu, String matKhau) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ho = ho;
        this.tenDem = tenDem;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.chucVu = chucVu;
        this.matKhau = matKhau;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", ho=" + ho + ", tenDem=" + tenDem + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", trangThai=" + trangThai + ", chucVu=" + chucVu + ", matKhau=" + matKhau + '}';
    }

}
