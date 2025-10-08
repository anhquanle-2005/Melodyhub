package com.example.spotify.API;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAPI {
    @GET("/music/3")
    Call<ApiResponse> getMusic();
}
