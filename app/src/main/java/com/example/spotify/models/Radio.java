package com.example.spotify.models;

public class Radio {
    private String txt_ngheSi, txt_name, url1,url2,url3;

    public Radio(String txt_ngheSi, String txt_name, String url1, String url2, String url3) {
        this.txt_ngheSi = txt_ngheSi;
        this.txt_name = txt_name;
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
    }

    public String getTxt_ngheSi() {
        return txt_ngheSi;
    }

    public void setTxt_ngheSi(String txt_ngheSi) {
        this.txt_ngheSi = txt_ngheSi;
    }

    public String getTxt_name() {
        return txt_name;
    }

    public void setTxt_name(String txt_name) {
        this.txt_name = txt_name;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }
}
