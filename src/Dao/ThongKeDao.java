/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author baomt
 */
public class ThongKeDao {
  public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String THELOAI_SQL = "{CALL sp_TKTheLoai}";
    public static String THEONAM_SQL = "{CALL sp_TKTheoNam}";
    public static String THEOPM_SQL = "{CALL sp_TKTheosl}";
    public static String THEONXB_SQL = "{CALL sp_TheoNXB}";
//    public static String DIEMCHUYENDE_SQL = "{CALL sp_DiemChuyenDe}";
//    public static String TKDoanhThu_SQL = "{CALL sp_TKDoanhThu (?)}";

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getTheLoai() {
        String[] cols = {"TheLoai", "SoLuong", "NhieuNhat", "ItNhat"};
        return this.getListOfArray(THELOAI_SQL, cols);
    }

    public List<Object[]> getTheoNam() {
        String[] cols = {"Nam", "SoLuong", "NhieuNhat", "ItNhat"};
        return this.getListOfArray(THEONAM_SQL, cols);
    }
    public List<Object[]> getTheoPM() {
        String[] cols = { "SoLuong", "NhieuNhat", "ItNhat"};
        return this.getListOfArray(THEOPM_SQL, cols);
    }
    public List<Object[]> getTheoNXB() {
        String[] cols = { "MANXB","SoLuong" ,"NhieuNhat", "ItNhat"};
        return this.getListOfArray(THEONXB_SQL, cols);
    }
//
//    public List<Object[]> getDiemChuyenDe() {
//        String[] cols = {"ChuyenDe", "SoHV", "CaoNhat", "ThapNhat", "TrungBinh"};
//        return this.getListOfArray(DIEMCHUYENDE_SQL, cols);
//    }
//
//    public List<Object[]> getTKDoanhThu(int nam) {
//        String[] cols = {"ChuyenDe", "SoKH", "SoHV", "DoanhThu", "ThapNhat", "CaoNhat", "TrungBinh"};
//        return this.getListOfArray(TKDoanhThu_SQL, cols, nam);
//    }   
}
