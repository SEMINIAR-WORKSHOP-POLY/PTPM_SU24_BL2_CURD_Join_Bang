/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import main.config.DBConnect;
import main.entity.ChucVu;
import main.entity.NhanVien;

/**
 *
 * @author hangnt
 */
public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien> lists = new ArrayList<>();
        // Code 
        String sql = """
                    SELECT nv.id, nv.Ma,nv.Ten, nv.DiaChi, nv.Sdt, nv.GioiTinh, cv.Ma, cv.Ten
                    FROM NhanVien nv, ChucVu cv
                    WHERE nv.IdCV = cv.Id
                    AND NhanVien.TrangThai = 1
                   """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery(); // Du lieu tra ra cua cau SQL 
            while (rs.next()) {
                // B1: Khoi tao cac doi tuong khoa ngoai 
                ChucVu cv = new ChucVu();
                cv.setMa(rs.getString(7));
                cv.setTen(rs.getString(8));
                // B2: Khoi tao den doi tuong chinh 
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setDiaChi(rs.getString(4));
                nv.setSdt(rs.getString(5));
                nv.setGioiTinh(rs.getString(6));
                nv.setChucVu(cv);
                // B3: Add vao list 
                lists.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public boolean add(NhanVien nv) {
        int check = 0;
        String sql = """
                     INSERT INTO NhanVien (Ma,Ten,Sdt,GioiTinh,DiaChi,IdCV)
                     VALUES (?,?,?,?,?,?)
                    """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getSdt());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getDiaChi());
            ps.setObject(6, nv.getChucVu().getId());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(Integer id, NhanVien nv) {
        int check = 0;
        // tu viet
        return check > 0;
    }

    public boolean remove(Integer id) {
        int check = 0;
        String sql = """
                     UPDATE [dbo].[NhanVien]
                            SET [trangthai] = 0 
                          WHERE ID = ?
                     """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }

    public static void main(String[] args) {
//        System.out.println(new NhanVienRepository().getAll());
        for (NhanVien nv : new NhanVienRepository().getAll()) {
            System.out.println(nv);
        }
    }
}
