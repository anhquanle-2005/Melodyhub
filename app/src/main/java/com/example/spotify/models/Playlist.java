package com.example.spotify.models;


import java.util.List;

public class Playlist {
   private String txt_bh, txt_nghesi,url;
   private List<Music> playlist;

    public Playlist(String txt_bh, String txt_nghesi, String url, List<Music> playlist) {
        this.txt_bh = txt_bh;
        this.txt_nghesi = txt_nghesi;
        this.url = url;
        this.playlist = playlist;
    }

    public Playlist(String txt_bh, String txt_nghesi, String url) {
        this.txt_bh = txt_bh;
        this.txt_nghesi = txt_nghesi;
        this.url = url;
    }

    public List<Music> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Music> playlist) {
        this.playlist = playlist;
    }

    public String getTxt_bh() {
        return txt_bh;
    }

    public void setTxt_bh(String txt_bh) {
        this.txt_bh = txt_bh;
    }

    public String getTxt_nghesi() {
        return txt_nghesi;
    }

    public void setTxt_nghesi(String txt_nghesi) {
        this.txt_nghesi = txt_nghesi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
