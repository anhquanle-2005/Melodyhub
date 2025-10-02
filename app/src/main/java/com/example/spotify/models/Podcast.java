package com.example.spotify.models;

public class Podcast {
    String tieuDe, tacGia, url, color;

    public Podcast(String tieuDe, String tacGia, String url, String color) {
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.url = url;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
}
