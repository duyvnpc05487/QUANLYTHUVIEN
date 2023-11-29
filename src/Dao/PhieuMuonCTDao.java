/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.PhieuMuonCT;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author baomt
 */
public class PhieuMuonCTDao extends QLThuVienDao<PhieuMuonCT, String> {

    final String INSERT_SQL = "INSERT CTPHIEUMUON(MaPM,SLSach,TongTien,MaSACH,GHICHU) VALUES (?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE CTPHIEUMUON SET SLSach = ?, TongTien = ?, MaSACH = ?,GHICHU = ? WHERE MaPM = ?";
    final String DELETE_SQL = "DELETE FROM CTPHIEUMUON WHERE MaPM = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM CTPHIEUMUON";
    final String SELECT_BYID_SQL = "SELECT * FROM CTPHIEUMUON WHERE MaPM = ?";

    @Override
    public void insert(PhieuMuonCT entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaPM(), entity.getSoLuong(), entity.getTongTien(),  entity.getMaSach(), entity.getGhiChu());
    }

    @Override
    public void update(PhieuMuonCT entity) {
      JdbcHelper.executeUpdate(UPDATE_SQL, entity.getSoLuong(), entity.getTongTien(),  entity.getMaSach(), entity.getGhiChu(),entity.getMaPM());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<PhieuMuonCT> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuMuonCT selectById(String id) {
        List<PhieuMuonCT> list = selectBySql(SELECT_BYID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<PhieuMuonCT> selectBySql(String sql, Object... args) {
        List<PhieuMuonCT> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                PhieuMuonCT entity = new PhieuMuonCT();
                entity.setMaPM(rs.getString("MaPM"));
                entity.setSoLuong(rs.getInt("SLSach"));
                entity.setTongTien(rs.getDouble("TongTien"));           
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaSach(rs.getString("MaSach"));

                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}


