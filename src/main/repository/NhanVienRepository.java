/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.config.DBConnect;
import main.entity.NhanVien;
import main.response.NhanVienResponse;

/**
 *
 * @author hangnt
 */
public class NhanVienRepository {

    public ArrayList<NhanVienResponse> getAll() {
        String sql = """
                    SELECT dbo.NhanVien.Id, dbo.NhanVien.Ma, dbo.NhanVien.Ten,
                     dbo.NhanVien.GioiTinh, dbo.NhanVien.DiaChi,
                     dbo.NhanVien.Sdt, dbo.ChucVu.Ma AS Expr1, dbo.ChucVu.Ten AS Expr2 
                    FROM  dbo.NhanVien INNER JOIN
                    dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id
                    WHERE NhanVien.TrangThai = 1
                    """;

        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            ArrayList<NhanVienResponse> lists = new ArrayList<>();
            while (rs.next()) {
                NhanVienResponse response = new NhanVienResponse(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8));
                lists.add(response);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    // Them Sua Xoa Giong 1 bang binh thuong
    public boolean add(NhanVien nhanVien) {

        int check = 0;

        String sql = """
                   INSERT INTO [dbo].[NhanVien]
                              ([Ma]
                              ,[Ten]
                              ,[GioiTinh]
                              ,[DiaChi]
                              ,[Sdt]
                              ,[IdCV]
                              ,[TrangThai])
                        VALUES(?,?,?,?,?,?,1);
                     
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nhanVien.getMa());
            ps.setString(2, nhanVien.getTen());
            ps.setString(3, nhanVien.getGioiTinh());
            ps.setString(4, nhanVien.getDiaChi());
            ps.setString(5, nhanVien.getSdt());
            ps.setInt(6, nhanVien.getIdChucVu());

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

}
