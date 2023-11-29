package Dao;

import utils.JdbcHelper;
import Entity.Sach;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author baomt
 */
public class SachDao extends QLThuVienDao<Sach, String> {

    final String INSERT_SQL = "INSERT INTO SACH(MaSACH,TenSACH,MATG,MANXB,MaTL,MOTA) VALUES (?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE SACH SET TenSACH = ?, MATG = ?, MANXB = ?,MATL = ?,MOTA = ? WHERE MaSACH = ?";
    final String DELETE_SQL = "DELETE FROM SACH WHERE MaSACH = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM SACH";
    final String SELECT_BYID_SQL = "SELECT * FROM SACH WHERE MaSACH = ?";
    
  public List<Sach> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM SACH WHERE TenSACH LIKE ?";
        return this.selectBySql(SQL, "%" + keyword + "%");
    }
    @Override
    public void insert(Sach entity) {
        String theLoaiString = String.join(",", entity.getTheLoai());
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaSACH(), entity.getTenSACH(), entity.getTacGIA(), entity.getNXB(), theLoaiString, entity.getMOTA());
    }

    @Override
    public void update(Sach entity) {
         String theLoaiString = String.join(",", entity.getTheLoai());
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenSACH(), entity.getTacGIA(), entity.getNXB(), theLoaiString, entity.getMOTA(), entity.getMaSACH());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<Sach> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Sach selectById(String id) {
        List<Sach> list = selectBySql(SELECT_BYID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                Sach entity = new Sach();
                entity.setMaSACH(rs.getString("MaSACH"));
                entity.setTenSACH(rs.getString("TenSACH"));
                entity.setTacGIA(rs.getString("MATG"));
                entity.setNXB(rs.getString("MANXB"));
                String theLoaiString = rs.getString("MaTL");
                ArrayList<String> theLoaiList = new ArrayList<>(Arrays.asList(theLoaiString.split(",")));
                entity.setTheLoai(theLoaiList);
//                entity.setTheLoai(rs.getString("MaTL"));
                entity.setMOTA(rs.getString("MOTA"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
