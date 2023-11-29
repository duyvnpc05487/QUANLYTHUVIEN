/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author baomt
 */
public class PhieuMuonCT {

    private String MaPM;
    private int SoLuong;
    private double TongTien;
    private String GhiChu;
    private String MaSach;

    public PhieuMuonCT() {
    }

    public PhieuMuonCT(String MaPM, int SoLuong, double TongTien, String GhiChu, String MaSach) {
        this.MaPM = MaPM;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
        this.MaSach = MaSach;
    }

    public String getMaPM() {
        return MaPM;
    }

    public void setMaPM(String MaPM) {
        this.MaPM = MaPM;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

}
