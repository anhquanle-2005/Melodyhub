package com.example.spotify.models;

public class Song {
    private String id,title,artist,imageUrl;;
    public Song(String id, String title, String artist, String imageUrl) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.imageUrl = imageUrl;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public String getImageUrl() {
        return imageUrl;
    }

}
