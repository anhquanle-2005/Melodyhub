package com.example.spotify.models;

public class premiumReason {

    private int iconRestid;
    private String title;
    public premiumReason(int iconRestid, String title) {
        this.iconRestid = iconRestid;
        this.title = title;
    }
    public int getIconRestid() {
        return iconRestid;
    }

    public String getTitle() {
        return title;
    }

}
