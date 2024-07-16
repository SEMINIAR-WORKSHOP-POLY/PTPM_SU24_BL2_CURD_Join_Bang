/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.repository;

import java.util.ArrayList;
import java.util.List;
import main.entity.ChucVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.config.DBConnect;

/**
 *
 * @author hangnt
 */
public class ChucVuRepository {

    public List<ChucVu> getAll() {
        List<ChucVu> lists = new ArrayList<>();
        // Code 
        // B1: Tao SQL 
        String sql = """
                   SELECT id, Ma, TEN
                   FROM ChucVu
                   """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery(); // Du lieu tra ra cua cau SQL 
            while (rs.next()) {
                ChucVu cv = new ChucVu(rs.getInt(1), rs.getString(2), rs.getString(3));
                lists.add(cv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public ChucVu getChucVuByMa(String ma) {
        // Code 
        // B1: Tao SQL 
        String sql = """
                   SELECT id, Ma, TEN
                   FROM ChucVu 
                   WHERE Ma = ?
                   """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery(); // Du lieu tra ra cua cau SQL 
            if (rs.next()) {
                return new ChucVu(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new ChucVuRepository().getAll());
    }
}
