package com.example.eventhub.Model;

public class SuKienSapToi {
    String TenSK, Poster,TrangThai,ThoiGian,Coso;
    int MaSK;


    public SuKienSapToi(String tenSK, String poster, String trangThai, String thoiGian, String coSo, int maSK) {
        TenSK = tenSK;
        Poster = poster;
        TrangThai = trangThai;
        ThoiGian = thoiGian;
        Coso = coSo;
        MaSK = maSK;
    }

    public String getCoSo() {
        return Coso;
    }

    public void setCoSo(String coSo) {
        Coso = coSo;
    }

    public String getTenSK() {
        return TenSK;
    }

    public void setTenSK(String tenSK) {
        TenSK = tenSK;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }

    public int getMaSK() {
        return MaSK;
    }

    public void setMaSK(int maSK) {
        MaSK = maSK;
    }
}
