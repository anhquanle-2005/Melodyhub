package com.example.spotify.models;

public class Music {

    private String tenbaiHat, tacGia, url;

    public Music(String tenbaiHat, String tacGia, String url) {
        this.tenbaiHat = tenbaiHat;
        this.tacGia = tacGia;
        this.url = url;
    }

    public String getTenbaiHat() {
        return tenbaiHat;
    }

    public void setTenbaiHat(String tenbaiHat) {
        this.tenbaiHat = tenbaiHat;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
