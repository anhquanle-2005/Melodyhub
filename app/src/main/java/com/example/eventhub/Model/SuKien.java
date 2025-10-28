package com.example.eventhub.Model;

import java.util.Date;

public class SuKien {
    String TenSK, Poster,TrangThai, AVT1, AVT2,AVT3, AVT4,ThoiGian;
    int MaSK;

    public SuKien(String tenSK, String poster, String trangThai, String AVT1, String AVT2, String AVT3, String AVT4, String thoiGian, int maSK) {
        TenSK = tenSK;
        Poster = poster;
        TrangThai = trangThai;
        this.AVT1 = AVT1;
        this.AVT2 = AVT2;
        this.AVT3 = AVT3;
        this.AVT4 = AVT4;
        ThoiGian = thoiGian;
        MaSK = maSK;
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

    public String getAVT1() {
        return AVT1;
    }

    public void setAVT1(String AVT1) {
        this.AVT1 = AVT1;
    }

    public String getAVT2() {
        return AVT2;
    }

    public void setAVT2(String AVT2) {
        this.AVT2 = AVT2;
    }

    public String getAVT3() {
        return AVT3;
    }

    public void setAVT3(String AVT3) {
        this.AVT3 = AVT3;
    }

    public String getAVT4() {
        return AVT4;
    }

    public void setAVT4(String AVT4) {
        this.AVT4 = AVT4;
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
