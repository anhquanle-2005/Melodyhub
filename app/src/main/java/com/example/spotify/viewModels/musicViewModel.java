package com.example.spotify.viewModels;

import com.example.spotify.models.music;

import java.util.ArrayList;
import java.util.List;

public class musicViewModel {
    private List<music> msl = new ArrayList<>();

    public musicViewModel() {
    }

    public List<music> getMsl() {
        return msl;
    }

    public List setView(){
        music ms1 = new music("Vết thương", "Fishy","https://i.scdn.co/image/ab67616d00001e02cb2a3066584a339e09508520");
        music ms3 = new music("BigTeam all stars", "BigDaddy, 7Dnight, DANGRANGTO, HURRYKNG, Pháp Kiều, $A Livan","https://i1.sndcdn.com/artworks-fqL73ggcxCeQtgsf-wQqmRQ-t1080x1080.jpg");
        music ms2 = new music("EZ","Sabbirose, 7Dnight, VCC Left Hand" ,"https://i.scdn.co/image/ab67616d00001e0203aeb634b34fed42641718a2");
        msl.add(ms1);
        msl.add(ms3);
        msl.add(ms2);

        return msl;

    }
}