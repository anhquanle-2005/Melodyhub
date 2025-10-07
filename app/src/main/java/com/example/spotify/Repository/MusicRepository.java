package com.example.spotify.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.spotify.API.ApiClient;
import com.example.spotify.API.ApiResponse;
import com.example.spotify.API.IAPI;
import com.example.spotify.models.Music;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicRepository {
    private final IAPI apiService;

    public MusicRepository() {
        apiService = ApiClient.getClient().create(IAPI.class);
    }

    public void fetchMusic(MutableLiveData<List<Music>> liveData, MutableLiveData<String> error) {
        Call<ApiResponse> call = apiService.getMusic();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(response.body().getGetmusic());
                } else {
                    error.setValue("Response null or failed");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage(), t);
                error.setValue(t.getMessage());
            }
        });
    }
}
