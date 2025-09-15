package com.example.spotify.viewModels;

import com.example.spotify.models.playlist;
import com.example.spotify.models.radio;

import java.util.ArrayList;
import java.util.List;

public class playlistViewModel {
    private List<playlist> pll = new ArrayList<>();
    public playlistViewModel() {
    }

    public List<playlist> getPll() {
        return pll;
    }

    public List setView(){
        playlist pl1 = new playlist("Vết thương", "Fishy","https://i.scdn.co/image/ab67616d00001e02cb2a3066584a339e09508520");
        playlist pl2 = new playlist("BigTeam all stars", "BigDaddy, 7Dnight, DANGRANGTO, HURRYKNG","https://i1.sndcdn.com/artworks-fqL73ggcxCeQtgsf-wQqmRQ-t1080x1080.jpg");
        playlist pl3= new playlist("EZ", "Sabbirose, 7Dnight, VCC Left Hand","https://i.scdn.co/image/ab67616d00001e0203aeb634b34fed42641718a2");

        pll.add(pl1);
        pll.add(pl2);
        pll.add(pl3);

        return pll;

    }
}
