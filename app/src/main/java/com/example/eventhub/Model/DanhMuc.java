package com.example.eventhub.Model;

public class DanhMuc {
    String text;
    int anh;

    public DanhMuc(String text, int anh) {
        this.text = text;
        this.anh = anh;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
