package com.example.spotify.viewModels;

import com.example.spotify.models.Playlist;

import java.util.ArrayList;
import java.util.List;

public class PlaylistViewModel {
    private List<Playlist> pll = new ArrayList<>();
    public PlaylistViewModel() {
    }

    public List<Playlist> getPll() {
        return pll;
    }

    public List setView(){
        Playlist pl1 = new Playlist("Vết thương", "Fishy","https://i.scdn.co/image/ab67616d00001e02cb2a3066584a339e09508520");
        Playlist pl2 = new Playlist("BigTeam all stars", "BigDaddy, 7Dnight, DANGRANGTO, HURRYKNG","https://i1.sndcdn.com/artworks-fqL73ggcxCeQtgsf-wQqmRQ-t1080x1080.jpg");
        Playlist pl3= new Playlist("EZ", "Sabbirose, 7Dnight, VCC Left Hand","https://i.scdn.co/image/ab67616d00001e0203aeb634b34fed42641718a2");

        pll.add(pl1);
        pll.add(pl2);
        pll.add(pl3);

        return pll;

    }
}
