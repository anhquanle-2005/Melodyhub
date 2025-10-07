package com.example.spotify.API;

import com.example.spotify.models.Music;

import java.util.List;

public interface ApiCallback {
    void onSuccess(List<Music> musicList);
    void onError(Throwable t);
}

