package com.example.spotify.API;

import com.example.spotify.models.Music;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("getmusic")
    private List<Music> getmusic;

    public List<Music> getGetmusic() {
        return getmusic;
    }
}
