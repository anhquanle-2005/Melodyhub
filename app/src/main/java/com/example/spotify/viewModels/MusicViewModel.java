package com.example.spotify.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.spotify.models.Music;
import com.example.spotify.Repository.MusicRepository;

import java.util.List;

public class MusicViewModel extends ViewModel {
    private final MusicRepository repository = new MusicRepository();

    private final MutableLiveData<List<Music>> musicList = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public LiveData<List<Music>> getMusicList() {
        return musicList;
    }



    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void loadMusic() {
        repository.fetchMusic(musicList, errorMessage);
    }
}
