package com.example.spotify.models;

import java.io.Serializable;

public class Music implements Serializable {

    private String TenBaiHat, Anh, DuongDan,TenNgheSi;

    public Music(String tenBaiHat, String anh, String duongDan, String tenNgheSi) {
        TenBaiHat = tenBaiHat;
        Anh = anh;
        DuongDan = duongDan;
        TenNgheSi = tenNgheSi;
    }

    public String getDuongDan() {
        return DuongDan;
    }

    public void setDuongDan(String duongDan) {
        DuongDan = duongDan;
    }

    public String getTenBaiHat() {
        return TenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        TenBaiHat = tenBaiHat;
    }

    public String getTenNgheSi() {
        return TenNgheSi;
    }

    public void setTenNgheSi(String tenNgheSi) {
        TenNgheSi = tenNgheSi;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }
}
