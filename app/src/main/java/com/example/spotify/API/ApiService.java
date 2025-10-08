package com.example.spotify.API;

import com.example.spotify.models.Music;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/search")
    Call<List<Music>> searchMusic(@Query("q")String query);
}
