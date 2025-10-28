package com.example.eventhub.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eventhub.Model.SuKien;
import com.example.eventhub.Model.SuKienSapToi;
import com.example.eventhub.Repository.SuKienRepository;

import java.util.List;

public class SuKienViewModel extends ViewModel {
    private final SuKienRepository repository = new SuKienRepository();
    private final MutableLiveData<List<SuKien>> lSuKien = new MutableLiveData<>();
    private final MutableLiveData<List<SuKienSapToi>> lSuKienSapToi = new MutableLiveData<>();
    private final MutableLiveData<List<SuKienSapToi>> lSuKiendanhchobn= new MutableLiveData<>();
    private final MutableLiveData<String> err = new MutableLiveData<>();

    public MutableLiveData<List<SuKien>> getlSuKien() {
        return lSuKien;
    }

    public MutableLiveData<List<SuKienSapToi>> getlSuKiendanhchobn() {
        return lSuKiendanhchobn;
    }

    public MutableLiveData<List<SuKienSapToi>> getlSuKienSapToi() {
        return lSuKienSapToi;
    }

    public MutableLiveData<String> getErr() {
        return err;
    }
    public void loadSuKien()
    {
        if(lSuKien.getValue()!=null && !lSuKien.getValue().isEmpty())
            return;
        repository.getSK(lSuKien,err);
    }
    public void load_SK_SapToi()
    {
        if(lSuKienSapToi.getValue()!=null && !lSuKienSapToi.getValue().isEmpty())
            return;
        repository.getSKSaptoi(lSuKienSapToi,err);
    }
    public void load_SK_danhchobn()
    {
        if(lSuKiendanhchobn.getValue()!=null && !lSuKiendanhchobn.getValue().isEmpty())
            return;
        repository.getSKSaptoi(lSuKiendanhchobn,err);
    }
}
