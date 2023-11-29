/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.PhieuMuon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author baomt
 */
public class PhieuMuonDao extends QLThuVienDao<PhieuMuon, String> {
    
 final String INSERT_SQL = "INSERT PHIEUMUON(MaPM,NGAYTAO,NGAYTRA,TRANGTHAI,MaNV,MaDG) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE PHIEUMUON SET NGAYTAO = ?, NGAYTRA = ?, TRANGTHAI = ?,MaNV = ?,MaDG = ? WHERE MaPM = ?";
    final String DELETE_SQL = "DELETE FROM PHIEUMUON WHERE MaPM = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM PHIEUMUON";
    final String SELECT_BYID_SQL = "SELECT * FROM PHIEUMUON WHERE MaPM = ?";

    @Override
    public void insert(PhieuMuon entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaDG(), entity.getNGAYTAO(), entity.getNGAYTRA(), entity.isTRANGTHAI(), entity.getMaNV(), entity.getMaDG());
    }

    @Override
    public void update(PhieuMuon entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getNGAYTAO(), entity.getNGAYTRA(), entity.isTRANGTHAI(), entity.getMaNV(), entity.getMaDG(), entity.getMaDG());

    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<PhieuMuon> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuMuon selectById(String id) {
        List<PhieuMuon> list = selectBySql(SELECT_BYID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<PhieuMuon> selectBySql(String sql, Object... args) {
        List<PhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                PhieuMuon entity = new PhieuMuon();
                entity.setMaPM(rs.getString("MaPM"));
                entity.setNGAYTAO(rs.getDate("NgayTao"));
                entity.setNGAYTRA(rs.getDate("NgayTra"));
                entity.setTRANGTHAI(rs.getBoolean("TrangThai"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaDG(rs.getString("MaDG"));
                

                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}

