package com.example.eventhub.API;

import com.example.eventhub.Model.SuKien;
import com.example.eventhub.Model.SuKienSapToi;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("getSK")
    private List<SuKien> getSK;
    @SerializedName("getsksaptoi")
    private  List<SuKienSapToi> SuKienSapToi;
    public List<SuKien> getGetSK() {
        return getSK;
    }

    public List<SuKienSapToi> getSuKienSapToi() {
        return SuKienSapToi;
    }
}
