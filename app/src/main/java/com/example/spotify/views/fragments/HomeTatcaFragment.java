package com.example.spotify.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify.R;
import com.example.spotify.adapter.MusicAdapter;
import com.example.spotify.adapter.NghesiAdapter;
import com.example.spotify.adapter.PlaylistAdapter;
import com.example.spotify.adapter.PodcastAdapter;
import com.example.spotify.adapter.RadioAdapter;
import com.example.spotify.models.Music;
import com.example.spotify.models.Nghesi;
import com.example.spotify.models.Playlist;
import com.example.spotify.models.Podcast;
import com.example.spotify.models.Radio;
import com.example.spotify.viewModels.MusicViewModel;
import com.example.spotify.viewModels.NghesiViewModel;
import com.example.spotify.viewModels.PlaylistViewModel;
import com.example.spotify.viewModels.PodcastViewModel;
import com.example.spotify.viewModels.RadioViewModel;
import com.example.spotify.views.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeTatcaFragment extends Fragment {
    private RecyclerView rcvmusic,rcvradio,rcvplaylist, rcvnghesi,rcv_podcast;
    private List<Music> mListmusic;
    private MusicAdapter msAdapter;
    private List<Radio> mListradio;
    private RadioAdapter radioAdapter;
    private List<Playlist> lplay;
    private List<Nghesi> lnghesi;
    private NghesiAdapter nsAdapter;
    private PlaylistAdapter playlistAdapter;
    private PodcastAdapter podcastAdapter;
    private List<Podcast> lPodcast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_tatca, container, false);
        addView(v);
        addViewPodcast(v);
        return v;
    }

    private void addViewPodcast(View v) {
        rcv_podcast = v.findViewById(R.id.rcv_tatca_padcast);
        lPodcast = new ArrayList<>();
        PodcastViewModel podcastVM = new PodcastViewModel();
        lPodcast = podcastVM.setPodcast();
        podcastAdapter = new PodcastAdapter(lPodcast);
        LinearLayoutManager lm = new LinearLayoutManager(v.getContext());
        rcv_podcast.setLayoutManager(lm);
        rcv_podcast.setAdapter(podcastAdapter);
    }


    private void addView(View v) {

        rcvmusic=v.findViewById(R.id.rcvms);
        mListmusic = new ArrayList<>();
        MusicViewModel mvd = new MusicViewModel();
        mListmusic = mvd.setView();
        msAdapter = new MusicAdapter(mListmusic);
        LinearLayoutManager lm = new LinearLayoutManager(v.getContext());
        rcvmusic.setLayoutManager(lm);


        msAdapter.setOnItemClickListener(new MusicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Music ms) {
                if(ms.getTenbaiHat().equals("BigTeam all stars"))
                {
                    ((MainActivity) requireActivity()).showFragment(new PlayMusicFragment(), "PlayMusic");
                    ((MainActivity) requireActivity()).addFragmentMusic(new ViewMusicFragment(), "music");
                }
            }
        });
        rcvmusic.setAdapter(msAdapter);
        //view radio
        rcvradio=v.findViewById(R.id.rcv_radio);
        mListradio = new ArrayList<>();
        RadioViewModel rvd = new RadioViewModel();
        mListradio = rvd.setView();
        radioAdapter = new RadioAdapter(mListradio);
        LinearLayoutManager lm1 = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rcvradio.setLayoutManager(lm1);
        rcvradio.setAdapter(radioAdapter);
        // view playlist
        rcvplaylist=v.findViewById(R.id.rcv_dexuat);
        lplay= new ArrayList<>();
        PlaylistViewModel plvd = new PlaylistViewModel();
        lplay = plvd.setView();
        playlistAdapter = new PlaylistAdapter(lplay);
        LinearLayoutManager lm2 = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rcvplaylist.setLayoutManager(lm2);
        rcvplaylist.setAdapter(playlistAdapter);
        // View nghe si
        rcvnghesi = v.findViewById(R.id.rcv_nghesi);
        lnghesi = new ArrayList<>();
        NghesiViewModel nsVM = new NghesiViewModel();
        lnghesi = nsVM.addView();
        nsAdapter = new NghesiAdapter(lnghesi);
        LinearLayoutManager lm3 = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL, false);
        rcvnghesi.setLayoutManager(lm3);
        rcvnghesi.setAdapter(nsAdapter);
    }
}