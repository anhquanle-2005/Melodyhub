package com.example.spotify.viewModels;

import com.example.spotify.models.music;
import com.example.spotify.models.radio;

import java.util.ArrayList;
import java.util.List;

public class radioViewModel {
    private List<radio> rdo = new ArrayList<>();
    public radioViewModel() {
    }

    public List<radio> getrdo() {
        return rdo;
    }

    public List setView(){
        radio rd1 = new radio("TLinh, Sơn Tùng MTP, Obito", "Obito","https://i.scdn.co/image/ab67616d00001e02cb2a3066584a339e09508520","https://i1.sndcdn.com/artworks-fqL73ggcxCeQtgsf-wQqmRQ-t1080x1080.jpg","https://i.scdn.co/image/ab67616d00001e0203aeb634b34fed42641718a2");
        radio rd2 = new radio("TLinh, Sơn Tùng MTP, Obito", "Obito","https://i.scdn.co/image/ab67616d00001e02cb2a3066584a339e09508520","https://i1.sndcdn.com/artworks-fqL73ggcxCeQtgsf-wQqmRQ-t1080x1080.jpg","https://i.scdn.co/image/ab67616d00001e0203aeb634b34fed42641718a2");
        radio rd3= new radio("TLinh, Sơn Tùng MTP, Obito", "Obito","https://i.scdn.co/image/ab67616d00001e02cb2a3066584a339e09508520","https://i1.sndcdn.com/artworks-fqL73ggcxCeQtgsf-wQqmRQ-t1080x1080.jpg","https://i.scdn.co/image/ab67616d00001e0203aeb634b34fed42641718a2");

        rdo.add(rd1);
        rdo.add(rd2);
        rdo.add(rd3);

        return rdo;

    }
}
