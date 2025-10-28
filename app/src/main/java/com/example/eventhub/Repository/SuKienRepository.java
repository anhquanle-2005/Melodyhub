package com.example.eventhub.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.eventhub.API.ApiClient;
import com.example.eventhub.API.ApiResponse;
import com.example.eventhub.API.IAPI;
import com.example.eventhub.Model.SuKien;
import com.example.eventhub.Model.SuKienSapToi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuKienRepository {
    private final IAPI apiService;
    public SuKienRepository()
    {
        apiService = ApiClient.getClient().create(IAPI.class);
    }
    public void getSK(MutableLiveData<List<SuKien>> liveData, MutableLiveData<String> err){
        Call<ApiResponse> call = apiService.getSK();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                liveData.postValue(response.body().getGetSK());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage(),t);
                err.setValue(t.getMessage());
            }
        });
    }
    public void getSKSaptoi(MutableLiveData<List<SuKienSapToi>> liveData, MutableLiveData<String>err){
        Call<ApiResponse> call = apiService.getSKSapToi();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                liveData.setValue(response.body().getSuKienSapToi());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("API_ERROR",t.getMessage(),t);
                err.setValue(t.getMessage());
            }
        });
    }
}
