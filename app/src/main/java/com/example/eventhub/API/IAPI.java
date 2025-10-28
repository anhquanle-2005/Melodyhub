package com.example.eventhub.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IAPI {
    @GET("/sukien/sapdienra")
    Call<ApiResponse> getSK();
    @GET("/sukien/saptoi")
    Call<ApiResponse> getSKSapToi();
    @FormUrlEncoded
    @POST("chitiet")
    Call<ApiResponse> chitiet(
            @Field("maSK") String ma
    );
}
